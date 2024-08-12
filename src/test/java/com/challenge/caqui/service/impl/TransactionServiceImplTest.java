package com.challenge.caqui;

import com.challenge.caqui.controller.dto.TransactionDto;
import com.challenge.caqui.repository.entity.TransactionEntity;
import com.challenge.caqui.service.impl.TransactionServiceImpl;
import com.challenge.caqui.repository.AccountRepository;
import com.challenge.caqui.repository.MerchantRepository;
import com.challenge.caqui.repository.TransactionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private MerchantRepository merchantRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    void testSuccessfulTransaction() {
        UUID accountId = UUID.randomUUID();
        String merchant = "ifood";
        double amount = 100.0;
        int mcc = 1234;

        TransactionDto transactionDto = new TransactionDto(accountId, amount, merchant, mcc);

        when(transactionRepository.save(any(TransactionEntity.class))).thenReturn(Mono.empty());

        transactionService.authorize(transactionDto)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

        verify(accountRepository).findById(accountId);
        verify(transactionRepository).save(any(TransactionEntity.class));
    }

    @Test
    void testInsufficientBalance() {
        UUID accountId = UUID.randomUUID();
        String merchant = "uber";
        double amount = 100.0;
        int mcc = 1234;

        TransactionDto transactionDto = new TransactionDto(accountId, amount, merchant, mcc);

        transactionService.authorize(transactionDto)
                .as(StepVerifier::create)
                .verifyComplete();

        verify(accountRepository).findById(accountId);
        verifyNoMoreInteractions(accountRepository, merchantRepository, transactionRepository);
    }

}

