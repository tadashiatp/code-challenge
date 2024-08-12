package com.challenge.caqui.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.challenge.caqui.common.enums.BenefitCategory;

@Getter
@Setter
@Table("mcc")
public class MccEntity {

    @Id
    Integer mcc;

    BenefitCategory category;


    public MccEntity(Integer mcc, BenefitCategory category) {
        this.mcc = mcc;
        this.category = category;
    }
}


