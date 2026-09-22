package com.oop;

public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative, got: " + openingBalance);
        }
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
    }

    public BankAccount(String accountHolder) {
        this(accountHolder, 0);
    }

    public BankAccount() {
        // deliberately empty — accountHolder stays null, balance stays 0.0
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive, got: " + amount);
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive, got: " + amount);
        }
        if (amount > this.balance) {
            System.out.println("Insufficient Funds");
            return;
        }
        this.balance -= amount;
    }

    public void getAccountDetails() {
        System.out.println("Name: " + this.accountHolder + ", Balance: " + this.balance);
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
