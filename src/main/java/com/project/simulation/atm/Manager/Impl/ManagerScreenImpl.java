package com.project.simulation.atm.Manager.Impl;

import com.project.simulation.atm.Componet.CommandLine;
import com.project.simulation.atm.Manager.ManagerScreen;
import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Model.AtmMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;


@Service
public class ManagerScreenImpl implements ManagerScreen {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerScreenImpl.class);

    @Autowired
    CommandLine readData;

    @Override
    public int getValidInput() {
        int integer = -100;
        try {
            integer = readData.getInputInt();
        } catch (InputMismatchException ex) {
            LOG.error("InputMismatchException invalid input!", ex.getMessage());
            readData.readNext();
        }
        return integer;
    }

    @Override
    public boolean isValidWithdraw(AtmMachine atmMachine, Account account, int withdrawAmount, int[] result) {
            return withdrawAmount < 20 || withdrawAmount > atmMachine.getAmount() ||
                    withdrawAmount > account.getBalance() || (result[0] == 0 && result[1] == 0);
    }


}
