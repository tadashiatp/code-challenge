package com.challenge.caqui.service;

import com.challenge.caqui.common.enums.BenefitCategory;
import com.challenge.caqui.common.enums.ResponseCode;
import com.challenge.caqui.controller.dto.*;

import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionResponseDto> authorize(TransactionDto transaction);

    Mono<ResponseCode> process(TransactionDto dto, BenefitCategory category);

}