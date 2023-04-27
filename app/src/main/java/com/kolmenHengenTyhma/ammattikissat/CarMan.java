package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class CarMan extends Cat{
    //attributes
    private int abilityDuration;
    //constructor
    public CarMan(String colour) {
        super(colour, 18, 18, 8, 4, 0);
    }

    //actions
    @Override
    public int getAttackDamage(){//Overriding parent attack method to deal with special
        if(abilityDuration > 0){
            abilityDuration=-1;
            if(abilityDuration<=0){//When ability duration 0
                this.luck=0;//Set luck back to natural luck of 0
            }
        }
        return super.getAttackDamage();
    }
    @Override

    public String uniqueAbility(){//Unique ability that increases luck by 3 points for next attack, CAN stack
        this.abilityDuration += 1;
        String output = "Käytit oman kyvyn. Sinun tuuri on kasvanut vuoroksi kolmella(nousi " + this.luck + ":sta ";
        this.luck=3;//
        output = output + this.luck + ":een";
        return(output);
    }
}
