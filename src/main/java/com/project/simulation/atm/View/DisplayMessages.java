package com.project.simulation.atm.View;

import com.project.simulation.atm.Model.AtmMachine;
import org.springframework.stereotype.Component;

@Component
public class DisplayMessages {

    public void menuChoice(){
        System.out.println("\n\nPlease choose one of the Following Options:" +
                "\n 1. Display Account Balance (press 1) \n 2. Deposit (press 2)" +
                "\n 3. Withdraw (press 3)\n 4. Atm Balance (press 4)" +
                "\n 5. Log Out (press 0)\n 6. Exit (press -1)");
    }

    public void wrongOption() {
        System.out.println("Please choose one of the Options [ 0 1 2 3 ] \n");
    }

    public void displayAccountBalance(int balance) {
        System.out.printf("Your account balance is: %d \n", balance);
    }

    public void logOut() {
        System.out.println("Your have successfully log out!!!");
    }

    public void exit() {
        System.out.println("GOOD BYE!!!");
    }

    public void displayAtmBalance(AtmMachine atmMachine) {
        atmMachine.printTotalAmount();
    }

    public void messageDeposit() {
        System.out.println("You would like to Deposit, Give an amount of money:  \n");
    }

    public void messageWithdraw() {
        System.out.println("You would like to Withdraw, Give an amount of money:  \n");
    }

    public void messageWrongValue() {
        System.out.println(" Please, Try again !!!\n");
    }

    public void messageWithdrawValidAmount() {
        System.out.println("You would like to Withdraw, Give a VALID amount of money:  \n");
    }

    public void messageWithdrawConfirm(int[] result) {
        System.out.printf("Would you like to Withdraw.\nAvailable amount: 20*%d + 50*%d\n" +
                                "yes (press 1) or no (press O)? \n\n", result[0], result[1]);
    }
}
