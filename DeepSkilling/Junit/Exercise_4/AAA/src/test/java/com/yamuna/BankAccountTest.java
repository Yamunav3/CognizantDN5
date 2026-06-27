package com.yamuna;

import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeClass
    public static void setupClass() {
        System.out.println("=== Starting BankAccountTest suite ===");
    }

    @AfterClass
    public static void teardownClass() {
        System.out.println("=== Finished BankAccountTest suite ===");
    }

    @Before
    public void setUp() {
        account = new BankAccount(100.0);
        System.out.println("Setup: new BankAccount created with balance 100.0");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("Teardown: account reference cleared");
    }

    @Test
    public void testDeposit_increasesBalance() {
        // Arrange
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals("Balance should increase by deposit amount", expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_decreasesBalance() {
        // Arrange
        double withdrawAmount = 30.0;
        double expectedBalance = 70.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals("Balance should decrease by withdrawal amount", expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_insufficientBalance_throwsException() {
        // Arrange
        double withdrawAmount = 500.0;

        // Act & Assert
        try {
            account.withdraw(withdrawAmount);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Insufficient balance", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeposit_negativeAmount_throwsException() {
        // Arrange
        double invalidAmount = -10.0;

        // Act (exception expected, handled by @Test annotation)
        account.deposit(invalidAmount);
    }
}