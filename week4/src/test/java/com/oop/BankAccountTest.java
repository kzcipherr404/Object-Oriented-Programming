package com.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {
    @Test
    void testDeposit() {
        // Arrange
        BankAccount account = new BankAccount();
        // Act
        account.deposit(100.0);
        // Assert
        assertEquals(100.0, account.balance);
    }
}
