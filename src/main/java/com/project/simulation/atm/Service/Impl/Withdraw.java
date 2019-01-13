package com.project.simulation.atm.Service.Impl;

import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Service.TransactionService;

public class Withdraw extends TransactionService {

    public Withdraw(int amount, Account act) {
        super(amount,  act);
    }

    public void execute() {
        this.account.setBalance(this.account.getBalance() - this.amount);
    }
}
