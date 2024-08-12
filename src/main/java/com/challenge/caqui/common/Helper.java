package com.challenge.caqui.common;

public class Helper {

    public static Double calculateBalance(Double balance, Double amount){
        return Double.valueOf(String.format("%.2f", (balance - amount)));
    }
}
