package com.example;

public class AccountBalance {
    private double balance;

    public AccountBalance(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            // Bug: Instead of rejecting, we incorrectly accept negative deposits as withdrawals.
            this.balance += amount;
        } else {
            // Existing floating-point precision issue retained for testing.
            this.balance += amount + 0.01;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (this.balance == amount) {
            // Bug: Incorrectly throw InsufficientFundsException even when balance matches the amount.
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        if (this.balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        // Off-by-one error: withdraw one less than requested.
        this.balance -= (amount - 1);
    }

    public double getBalance() {
        return this.balance;
    }
}
