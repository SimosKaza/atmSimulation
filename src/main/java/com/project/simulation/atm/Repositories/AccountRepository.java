package com.project.simulation.atm.Repositories;

import com.project.simulation.atm.Componet.RandomNumber;
import com.project.simulation.atm.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    @Autowired
    RandomNumber randomNumber;

    public Account findById(long id){
        Account user = new Account();
        user.setAccountId(id);
        user.setBalance( randomNumber.getNumber(100,  1000));
        user.setFirstName("Foula");
        user.setLastName("Sokolatoula");
        return user;
    }

}
