package com.project.simulation.atm.Manager;

import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Model.AtmMachine;

public interface ManagerScreen {
    int getValidInput();

    boolean isValidWithdraw(AtmMachine atmMachine, Account account, int withdrawAmount, int[] result);
}
