package com.yamuna;

/**
 * Hello world!
 *
 */
// src/main/java/com/yamuna/App.java


public class App {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);

        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(50.0);
        System.out.println("After deposit of 50: " + account.getBalance());

        account.withdraw(30.0);
        System.out.println("After withdrawal of 30: " + account.getBalance());

        try {
            account.withdraw(1000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}