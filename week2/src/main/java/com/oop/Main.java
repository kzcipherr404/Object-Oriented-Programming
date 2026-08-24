package com.oop;

public class Main {

    static BankAccount jacobsAccount = new BankAccount();
    static BankAccount useAccount = new BankAccount();

    public static void main(String[] args) {
        System.out.println(jacobsAccount == useAccount);
    }
}