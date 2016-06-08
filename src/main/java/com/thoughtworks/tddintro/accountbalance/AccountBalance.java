package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by sarqhlohmeier on 6/3/16.
 */
public class AccountBalance {
    public int balance;

    public AccountBalance(int balance) {
        this.balance = balance;
    }
    public int deposit(int deposit) {
        balance += deposit;
        return balance;
    }

    public int withdraw(int withdrawal) {
        if (balance - withdrawal > 0) {
            balance -= withdrawal;
        }
        return balance;
    }

    public void setTo(int balance) {
        this.balance = balance;
    }
}
