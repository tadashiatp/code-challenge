package com.challenge.caqui.repository.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.challenge.caqui.common.enums.BenefitCategory;

@Getter
@Setter
@Table("merchant")
public class MerchantEntity {

    @Id
    UUID id;

    String name;

    BenefitCategory category;

    public MerchantEntity(String name, BenefitCategory category) {
        this.name = name;
        this.category = category;
    }
}

