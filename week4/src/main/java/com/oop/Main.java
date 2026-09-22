package com.oop;

public class Main {
    public static void main(String[] args) {
        // Part 1 & 2: Encapsulation and Private Balance
        BankAccount jacobsAccount = new BankAccount("Jacob", 0);
        jacobsAccount.deposit(500);

        // Direct access to jacobsAccount.balance causes a compiler error because balance is private.
        // Reading is done via public getter:
        System.out.println("Jacob's balance via getter: " + jacobsAccount.getBalance());

        // Part 3: Proving Access Levels in Same Package (com.oop)
        Probe p = new Probe();
        System.out.println("Public field: " + p.fieldPublic);
        System.out.println("Default field: " + p.fieldDefault);
        System.out.println("Protected field: " + p.fieldProtected);
        // System.out.println(p.fieldPrivate); // Fails: fieldPrivate has private access in Probe

        // Different package (package com) verification:
        new com.Auditor().inspect();

        // Part 5: Constructors and Overloading
        BankAccount b1 = new BankAccount("Jacob", 1000000);
        BankAccount b2 = new BankAccount("Jane");
        BankAccount b3 = new BankAccount();

        b1.getAccountDetails();
        b2.getAccountDetails();
        b3.getAccountDetails();

        // Part 6: Validation with Exceptions (Refuse Loudly)
        try {
            b1.deposit(-100);
            System.out.println("Deposited. New balance: " + b1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit rejected: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt logged.");
        }
    }
}
