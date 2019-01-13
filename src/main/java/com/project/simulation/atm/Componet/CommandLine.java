package com.project.simulation.atm.Componet;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class CommandLine {

    private Scanner input;

    public CommandLine() {
        input = new Scanner(System.in);
    }

    public int getInputInt() {
        return input.nextInt();
    }

    public Scanner getInput() {
        return input;
    }

    public void readNext() {
        input.next();
    }
}
