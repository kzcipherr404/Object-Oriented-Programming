package com.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount("Jacob", 50);
        account.deposit(100);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void negativeDepositIsRejected() {
        BankAccount account = new BankAccount("Jacob", 50);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
        assertEquals(50.0, account.getBalance()); // and nothing changed
    }

    @Test
    void negativeOpeningBalanceIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("Jacob", -50));
    }
}
