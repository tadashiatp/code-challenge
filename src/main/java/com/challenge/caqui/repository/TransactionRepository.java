package com.challenge.caqui.repository;

import com.challenge.caqui.repository.entity.TransactionEntity;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TransactionRepository extends R2dbcRepository<TransactionEntity, UUID> {
}