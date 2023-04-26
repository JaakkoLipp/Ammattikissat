package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class ElectricianMan extends Cat{
    //constructor
    public ElectricianMan(String colour) {
        super(colour, 20, 20, 5, 2, 1);
    }
    //actions
    public void uniqueAbility(){
        this.takeDMG(5);
        this.attackPower+=5;
    }
}
