package com.challenge.caqui.repository;

import com.challenge.caqui.repository.entity.MerchantEntity;

import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MerchantRepository extends R2dbcRepository<MerchantEntity, String> {

    Mono<MerchantEntity> findByName(String name);
    
}