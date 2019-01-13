package com.project.simulation.atm.Service;

import com.project.simulation.atm.Model.Account;

public abstract class TransactionService {

    protected int amount;
    protected Account account;

    public TransactionService(int amount, Account account) {
        this.amount = amount;
        this.account = account;
    }

    public abstract void execute();

}