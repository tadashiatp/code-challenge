package com.challenge.caqui.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.challenge.caqui.common.enums.ResponseCode;

@Getter
@AllArgsConstructor
public class TransactionResponseDto {

    private ResponseCode code;
}
