package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class LogisticsMan extends Cat{
    //atributes
    private int abilityDuration;
    //constructor
    public LogisticsMan(String colour) {
        super(colour, 14, 14, 3, 4, 2);
    }

    //actions
    @Override
    public int getAttackDamage(){//Overriding parent attack method to deal with special
        if(abilityDuration > 0){
            abilityDuration=-1;
            if(abilityDuration<=0){
                attackPower=-2;
            }
        }
        return super.getAttackDamage();//TODO : test if this shizzle works, i think so
    }
    @Override
    public void uniqueAbility(){ //Increase attack power for following 2 attacks
        this.abilityDuration = 2;//this method does NOT stack for balance reasons //TODO: should make that clear ingame
        this.attackPower+=2;
        //"Logiskissa attack power increased by 2 for 2 attacks!"
    }
}
