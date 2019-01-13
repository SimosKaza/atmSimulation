package com.project.simulation.atm.Service;

import com.project.simulation.atm.Model.AtmMachine;

public interface AtmService {

    int[] getAvailableCombination(int[] values, int[] ammounts, int[] variation, int position, int price );

    void reduceService(AtmMachine atmMachine, int[] result);
}
