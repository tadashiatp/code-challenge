package com.challenge.caqui.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {
    APPROVED("00"),
    INSUFFICIENT_BALANCE("51"),
    OTHER_ERROR("07"),
    TEST("24");


    private String code;

    private ResponseCode(String code) {
        this.code = code;
    }
   
    @JsonValue
    public String getDescription() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}

