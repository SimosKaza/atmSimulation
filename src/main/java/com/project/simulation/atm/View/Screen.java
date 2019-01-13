package com.project.simulation.atm.View;

import com.project.simulation.atm.Manager.ManagerScreen;
import com.project.simulation.atm.Model.Account;
import com.project.simulation.atm.Model.AtmMachine;
import com.project.simulation.atm.Model.Options;
import com.project.simulation.atm.Service.AccountService;
import com.project.simulation.atm.Service.AtmService;
import com.project.simulation.atm.Service.Impl.Deposit;
import com.project.simulation.atm.Service.Impl.Withdraw;
import com.project.simulation.atm.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Screen {

    @Autowired
    DisplayMessages displayMessages;

    @Autowired
    ManagerScreen managerScreen;

    @Autowired
    AccountService accountService;

    @Autowired
    AtmService atmService;

    public void start() {
        AtmMachine atmMachine = new AtmMachine();
        while(Boolean.TRUE){
            long accountId = 1_001_205;
            Account account = accountService.findAccount(accountId);
            while (Boolean.TRUE) {
                displayMessages.menuChoice();
                int menuOption = managerScreen.getValidInput();
                if (menuOption == Options.AccountBalance.getKey()) {
                    displayMessages.displayAccountBalance(account.getBalance());
                } else if (menuOption == Options.Deposit.getKey()) {
                    displayMessages.messageDeposit();
                    int depositAmount = managerScreen.getValidInput();
                    TransactionService withdraw = new Deposit(depositAmount, account);
                    accountService.transation(withdraw);
                } else if (menuOption ==  Options.Withdraw.getKey()) {
                    displayMessages.messageWithdraw();
                    int withdrawAmount = managerScreen.getValidInput();
                    int[] result = atmService.getAvailableCombination(atmMachine.getAvailableNotes(),
                                        atmMachine.getCounterOfNotes(), new int[2],0, withdrawAmount );
                    if (managerScreen.isValidWithdraw(atmMachine, account, withdrawAmount, result)) {
                        displayMessages.messageWrongValue();
                    } else {
                        displayMessages.messageWithdrawConfirm(result);
                        int withdrawConfirm = managerScreen.getValidInput();
                        if(withdrawConfirm == 1) {
                            TransactionService withdraw = new Withdraw(withdrawAmount, account);
                            accountService.transation(withdraw);
                            atmService.reduceService(atmMachine, result);
                        }
                    }
                } else if (menuOption == Options.AtmBalance.getKey()) {
                    displayMessages.displayAtmBalance(atmMachine);
                } else if (menuOption == Options.LogOut.getKey()) {
                    displayMessages.logOut();
                    break;
                } else if (menuOption == Options.Exit.getKey()) {
                    displayMessages.exit();
                    System.exit(-1);
                } else {
                    displayMessages.wrongOption();
                }
            }
        }
    }


}
