package com.project.simulation.atm.Service.Impl;

import com.project.simulation.atm.Model.AtmMachine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AtmServiceImplTest {

    int[] availableNotes = {20, 50};
    int[] counterOfNotes = {8, 5};

    @InjectMocks
    private AtmServiceImpl AtmService;


    @Before
    public void createMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAvailableCombinationNotes20() {
        int[] result = AtmService.getAvailableCombination(availableNotes, counterOfNotes,
                                    new int[2],0, 40 );
        Assert.assertEquals(result[0], 2);
        Assert.assertEquals(result[1], 0);
    }

    @Test
    public void getAvailableCombinationNotes50() {
        int[] result = AtmService.getAvailableCombination(availableNotes, counterOfNotes,
                new int[2],0, 50 );
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 1);
    }

    @Test
    public void getAvailableCombinationNotes20and50() {
        int[] result = AtmService.getAvailableCombination(availableNotes, counterOfNotes,
                new int[2],0, 70 );
        Assert.assertEquals(result[0], 1);
        Assert.assertEquals(result[1], 1);
    }

    @Test
    public void getAvailableCombinationInvalid() {
        int[] result = AtmService.getAvailableCombination(availableNotes, counterOfNotes,
                new int[2],0, 199 );
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 0);
    }

    @Test
    public void reduceService() {
        AtmMachine atmMachine = new AtmMachine();
        int[] atmValues = atmMachine.getCounterOfNotes().clone();
        int[] result = {1, 1};
        AtmService.reduceService(atmMachine, result);
        Assert.assertNotEquals(atmValues[0], atmMachine.getCounterOfNotes()[0]);
        Assert.assertNotEquals(atmValues[1], atmMachine.getCounterOfNotes()[1]);
    }
}