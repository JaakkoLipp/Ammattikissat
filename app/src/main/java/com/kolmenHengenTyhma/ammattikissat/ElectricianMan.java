package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class ElectricianMan extends Cat{
    //constructor
    public ElectricianMan(String colour) {
        super(colour, 20, 20, 5, 2, 1);
    }
    //actions
    public String uniqueAbility(){
        int takeDamage = 5;
        int increasePower = 5;

        this.takeDMG(takeDamage);
        String output =  ("Käytit oman kyvyn. Otit " + takeDamage + " pistettä vaihnkoa ja ");
        this.attackPower+=increasePower;
        output = output + ("hyökkäys voimaisi nousi " + increasePower + " verran. (Ennen " + (this.attackPower-increasePower) + ").");

        return (output);
    }
}
