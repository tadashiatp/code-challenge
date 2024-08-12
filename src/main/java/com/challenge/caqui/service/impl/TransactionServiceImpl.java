package com.challenge.caqui.service.impl;

import com.challenge.caqui.common.*;
import com.challenge.caqui.common.enums.*;
import com.challenge.caqui.controller.dto.*;
import com.challenge.caqui.repository.*;
import com.challenge.caqui.repository.entity.AccountEntity;
import com.challenge.caqui.service.TransactionService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final MccRepository mccRepository;
    private final MerchantRepository merchantRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Mono<TransactionResponseDto> authorize(TransactionDto dto) {
        return process(dto, null)
                .onErrorReturn(ResponseCode.OTHER_ERROR)
                .map(code -> new TransactionResponseDto(code))
                .defaultIfEmpty(new TransactionResponseDto(ResponseCode.OTHER_ERROR));
    }

    @Override
    public Mono<ResponseCode> process(TransactionDto dto, BenefitCategory category) {
        Mono<BenefitCategory> categoryMono = getCategory(dto, category);
        Mono<AccountEntity> accountMono = categoryMono.flatMap(cat ->{
            return accountRepository.findByAccountIdAndCategory(dto.account(), cat);
            
        });
        
        return accountMono.flatMap(
            acc -> {
                if (acc.getBalance() < dto.totalAmount()) {
                    if (category == BenefitCategory.CASH) {
                        return Mono.just(ResponseCode.INSUFFICIENT_BALANCE);
                    }
                    return process(dto, BenefitCategory.CASH);
                }
                Double balance = Helper.calculateBalance(acc.getBalance(), dto.totalAmount());
                transactionRepository.save(dto.toEntity())
                    .doOnSuccess(tr -> {
                        acc.setBalance(balance);
                        accountRepository.save(acc);
                    });

                return Mono.just(ResponseCode.APPROVED);
                
            });
    }

    private Mono<BenefitCategory> getCategory(TransactionDto dto, BenefitCategory category) {
        if (category != null) {
            return Mono.just(category);
        }
        Mono<BenefitCategory> found = merchantRepository.findByName(dto.merchant())
                                        .map(m -> m.getCategory());
        
        if (found == null) {
            found = mccRepository.findById(dto.mcc())
                    .map(m -> m.getCategory());
        }
        return found.defaultIfEmpty(BenefitCategory.CASH);
    }
}
