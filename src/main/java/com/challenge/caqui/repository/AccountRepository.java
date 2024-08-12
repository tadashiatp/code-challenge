package com.challenge.caqui.repository;

import com.challenge.caqui.common.enums.BenefitCategory;
import com.challenge.caqui.repository.entity.AccountEntity;

import reactor.core.publisher.Mono;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<AccountEntity, UUID> {


    @Query("SELECT * FROM account WHERE accountId = :accountId AND category = :category")
    Mono<AccountEntity> findByAccountIdAndCategory(UUID accountId, BenefitCategory category);
}