package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class RaksaMan extends Cat{

    //constructor
    public RaksaMan(String colour) {
        super(colour, 20, 20, 4, 6, 1);
    }

    //actions
    @Override
    public void uniqueAbility(){//Heal!
        if(currHP+4<=maxHP) {
            this.currHP += 4;
        }
    }

}
