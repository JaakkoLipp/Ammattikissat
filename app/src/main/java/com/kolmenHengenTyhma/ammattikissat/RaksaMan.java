package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class RaksaMan extends Cat{

    // CONST
    public RaksaMan(String colour) {
        super(colour, 20, 20, 4, 6, 1);
    }

    @Override
    public void uniqueAbility(){//Heal!
        if(currHP+4<=maxHP) {
            this.currHP += 4;
        }
    }

}
