package com.challenge.caqui.repository.entity;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import com.challenge.caqui.common.enums.BenefitCategory;

@Getter
@Setter
@Table("account")
public class AccountEntity {

    UUID accountId;

    BenefitCategory category;

    Double balance;

    @Builder
    public AccountEntity(UUID accountId, BenefitCategory category, Double balance) {
        this.accountId = accountId;
        this.category = category;
        this.balance = balance;
    }
}

