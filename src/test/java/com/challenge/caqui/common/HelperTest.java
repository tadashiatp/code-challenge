package com.challenge.caqui;

import org.junit.jupiter.api.Test;

import com.challenge.caqui.common.Helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperTest {

    @Test
    public void testCalculateBalanceReturnsCorrectValue() {
        // Given
        double balance = 100.0;
        double amount = 50.0;
        double expectedResult = 50.0;

        // When
        double result = Helper.calculateBalance(balance, amount);

        // Then
        assertEquals(expectedResult, result);
    }
    
}
