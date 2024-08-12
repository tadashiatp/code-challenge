package com.challenge.caqui.controller;

import com.challenge.caqui.controller.dto.TransactionDto;
import com.challenge.caqui.controller.dto.TransactionResponseDto;
import com.challenge.caqui.service.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    private final TransactionService transactionService;

    /**
     * Authorizes a transaction.
     *
     * @param dto	Trnsaction data
     * @return	Response code
     */
    @PostMapping
    Mono<TransactionResponseDto> authorizeTransaction(@Valid @RequestBody TransactionDto dto) {
      return transactionService.authorize(dto);
    }
}