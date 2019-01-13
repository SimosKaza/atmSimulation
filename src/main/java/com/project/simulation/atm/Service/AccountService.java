package com.project.simulation.atm.Service;

import com.project.simulation.atm.Model.Account;

public interface AccountService {
    Account findAccount(long accountId);

    void transation(TransactionService transaction);
}
