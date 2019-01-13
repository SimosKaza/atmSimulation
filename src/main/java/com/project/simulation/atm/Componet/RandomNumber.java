package com.project.simulation.atm.Componet;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;

@Component
public class RandomNumber {
    private final SecureRandom rand = new SecureRandom();

    public SecureRandom getRand() {
        return rand;
    }

    public int getNumber(int min, int max) {
        return this.rand.nextInt(max - min + 1) + min;
    }
}
