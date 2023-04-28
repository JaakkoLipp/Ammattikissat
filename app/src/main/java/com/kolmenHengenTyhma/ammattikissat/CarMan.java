package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class CarMan extends Cat{
    //attributes
    private int abilityDuration;
    private double luckIncrease = 3;
    private int abilityDurationIncrease = 1;
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
        this.abilityDuration += abilityDurationIncrease;
        String output = "Käytit oman kyvyn. Sinun tuuri on kasvanut vuoroksi kolmella(nousi " + this.luck + ":sta ";
        this.luck += luckIncrease;//
        output = output + this.luck + ":een " + abilityDurationIncrease + " vuoroksi.";
        return(output);
    }
    //setters

    public void setAbilityDuration(int abilityDuration) {
        this.abilityDuration = abilityDuration;
    }

    //getters
    public int getAbilityDuration() {
        return abilityDuration;
    }

    public double getLuckIncrease() {
        return luckIncrease;
    }

    public int getAbilityDurationIncrease() {
        return abilityDurationIncrease;
    }
}
