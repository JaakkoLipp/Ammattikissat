package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class CarMan extends Cat{
    private int abilityDuration;

    public CarMan(String colour) {
        super(colour, 18, 18, 8, 4, 0);
    }

    @Override
    public void attack(Cat catToAttack){//Overriding parent attack method to deal with special
        if(abilityDuration > 0){
            abilityDuration=-1;
            if(abilityDuration<=0){//When ability duration 0
                this.luck=0;//Set luck back to natural luck of 0
            }
        }
        super.attack(catToAttack);
    }
    @Override

    public void uniqueAbility(){//Unique ability that increases luck by 3 points for next attack, CAN stack
        this.abilityDuration += 1;
        this.luck=3;//
    }
}
