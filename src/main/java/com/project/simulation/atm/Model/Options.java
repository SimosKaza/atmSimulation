package com.project.simulation.atm.Model;

public enum Options {

    AccountBalance(1, "Display Account Balance"),
    Deposit(2, "Deposit"),
    Withdraw(3, "Withdraw"),
    AtmBalance(4, "Display Atm Balance"),
    LogOut(0, "Log Out"),
    Exit(-1, "Exit");

    private final Integer key;
    private final String value;


    Options(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
