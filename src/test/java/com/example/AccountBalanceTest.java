package com.example;

import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;

    public class AccountBalanceTest {

        @Test
        public void testPositiveDeposit() {
            AccountBalance balance = new AccountBalance(100.0);
            balance.deposit(50.0);
            assertEquals(150.0, balance.getBalance());
        }

        @Test
        public void testNegativeDeposit() {
            AccountBalance balance = new AccountBalance(100.0);
            assertThrows(IllegalArgumentException.class, () -> balance.deposit(-50.0));
        }

        @Test
        public void testZeroDeposit() {
            AccountBalance balance = new AccountBalance(100.0);
            assertThrows(IllegalArgumentException.class, () -> balance.deposit(0.0));
        }

        @Test
        public void testPositiveWithdrawal() {
            AccountBalance balance = new AccountBalance(100.0);
            balance.withdraw(50.0);
            assertEquals(50.0, balance.getBalance());
        }

        @Test
        public void testNegativeWithdrawal() {
            AccountBalance balance = new AccountBalance(100.0);
            assertThrows(IllegalArgumentException.class, () -> balance.withdraw(-50.0));
        }

        @Test
        public void testZeroWithdrawal() {
            AccountBalance balance = new AccountBalance(100.0);
            assertThrows(IllegalArgumentException.class, () -> balance.withdraw(0.0));
        }

        @Test
        public void testInsufficientFunds() {
            AccountBalance balance = new AccountBalance(100.0);
            assertThrows(InsufficientFundsException.class, () -> balance.withdraw(150.0));
        }

        @Test
        public void testDepositWithNegativeInitialBalance() {
            AccountBalance balance = new AccountBalance(-50.0);
            balance.deposit(100.0);
            assertEquals(50.0, balance.getBalance());
        }
    }