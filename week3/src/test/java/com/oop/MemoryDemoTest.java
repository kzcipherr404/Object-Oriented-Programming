package com.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryDemoTest {

    @Test
    void separateObjectsDoNotShareState() {
        // Arrange
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();
        // Act
        acc1.balance = 500;
        // Assert
        assertEquals(0, acc2.balance);
    }

    @Test
    void aliasedObjectsShareState() {
        // Arrange
        BankAccount acc1 = new BankAccount();
        acc1.balance = 500;
        BankAccount acc2 = acc1;
        // Act
        acc2.balance = 750;
        // Assert
        assertEquals(750, acc1.balance);
    }
}