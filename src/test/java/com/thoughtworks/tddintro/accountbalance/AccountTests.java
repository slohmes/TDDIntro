package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private AccountBalance balance = new AccountBalance(100);

    @Before
    public void setUp() throws Exception {
        balance = new AccountBalance(100);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        assertThat(balance.deposit(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        assertThat(balance.withdraw(50), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        balance.setTo(50);
        assertThat(balance.withdraw(100), is(50));

    }
}
