package com.project.simulation.atm.Service.Impl;

import com.project.simulation.atm.Model.AtmMachine;
import com.project.simulation.atm.Service.AtmService;
import org.springframework.stereotype.Service;
import java.util.stream.IntStream;

@Service
public class AtmServiceImpl implements AtmService {

    public int[] getAvailableCombination(int[] values, int[] ammounts, int[] variation, int position, int price ) {
        int[] list= new int[2];
        int value = IntStream.range(0, variation.length).map(i -> values[i] * variation[i]).sum();
        if (value < price) {
            for (int i = position; i < values.length; i++) {
                if (ammounts[i] > variation[i]) {
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    int[] newList = getAvailableCombination(values, ammounts, newvariation,  i, price);
                    if (newList[0] > 0 || newList[1] >0) {
                        list = newList;
                        break;
                    }
                }
            }
        } else if (value == price) {
            list = variation;
        }
        return list;
    }

    @Override
    public void reduceService(AtmMachine atmMachine, int[] result) {
       int[] notes = atmMachine.getCounterOfNotes();
       for(int i= 0; i< result.length; i++)
           notes[i] = notes[i]-result[i];
       atmMachine.setCounterOfNotes(notes);
    }
}
