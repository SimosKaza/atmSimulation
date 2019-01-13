package com.project.simulation.atm.Service.Impl;

import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Repositories.AccountRepository;
import com.project.simulation.atm.Service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountRepository accountRepository;

    @Test
    public void findAccount() {
        when(accountRepository.findById(Mockito.anyLong())).thenReturn(new Account());
        Account account = accountService.findAccount(123);
        Assert.assertNotNull(account);
    }

    @Test
    public void transationDeposit() {
        Account acount = new Account();
        TransactionService deposit = new Deposit(10, acount);
        int previous = acount.getBalance();
        accountService.transation(deposit);
        Assert.assertNotEquals(previous, acount.getBalance());
    }

    @Test
    public void transationWithdraw() {
        Account acount = new Account();
        TransactionService withdraw = new Withdraw(10, acount);
        int previous = acount.getBalance();
        accountService.transation(withdraw);
        Assert.assertNotEquals(previous, acount.getBalance());

    }
}