package com.challenge.caqui.controller.dto;

import java.util.UUID;

import com.challenge.caqui.repository.entity.TransactionEntity;

public record TransactionDto(
    UUID account,
    Double totalAmount,
    String merchant,
    Integer mcc) {

    public TransactionEntity toEntity() {
        return new TransactionEntity(
            account,
            totalAmount,
            merchant,
            mcc
        );
    }
}
