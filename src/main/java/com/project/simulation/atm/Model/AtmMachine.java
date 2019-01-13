package com.project.simulation.atm.Model;

import java.security.SecureRandom;

public class AtmMachine {

    private int amount;
    static int[] availableNotes = {20, 50};
    int[] counterOfNotes = {21, 21};


    public AtmMachine() {
        SecureRandom rand = new SecureRandom();
        this.counterOfNotes[0] = rand.nextInt(20)+  1;
        this.counterOfNotes[1] = rand.nextInt(10)+  1;
        printTotalAmount();
    }

    public void printTotalAmount() {
        System.out.println("------------ ATM Cash ------------");
        System.out.println("Total Amount: " + getAmount());
        System.out.println("Notes of 20: " + this.counterOfNotes[0]);
        System.out.println("Notes of 50: " + this.counterOfNotes[1]);
    }

    public int getAmount() {
        return this.counterOfNotes[0] * 20 + this.counterOfNotes[1] * 50;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int[] getAvailableNotes() {
        return availableNotes;
    }

    public int[] getCounterOfNotes() {
        return counterOfNotes;
    }

    public void setCounterOfNotes(int[] counterOfNotes) {
        this.counterOfNotes = counterOfNotes;
    }
}
