package com.project.simulation.atm.Service.Impl;

import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Repositories.AccountRepository;
import com.project.simulation.atm.Service.AccountService;
import com.project.simulation.atm.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findAccount(long accountId) {
        return  accountRepository.findById(accountId);
    }

    @Override
    public synchronized void transation(TransactionService transaction) {
        transaction.execute();
    }


}
