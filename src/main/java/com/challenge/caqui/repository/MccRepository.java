package com.challenge.caqui.repository;

import com.challenge.caqui.repository.entity.MccEntity;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MccRepository extends R2dbcRepository<MccEntity, Integer> {
}