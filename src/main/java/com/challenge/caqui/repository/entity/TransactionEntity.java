package com.challenge.caqui.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.CreatedDate;


@Getter
@Setter
@Table("transaction")
public final class TransactionEntity {

    @Id
    private UUID id;

    private UUID accountId;

    private Double amount;

    private Integer mcc;

    private String merchant;

    @CreatedDate
    private LocalDateTime createdAt;

    public TransactionEntity(UUID accountId, Double amount, String merchant, Integer mcc) {
        this.accountId = accountId;
        this.amount = amount;
        this.mcc = mcc;
        this.merchant = merchant;
    }
}

