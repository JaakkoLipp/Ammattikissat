package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class LogisticsMan extends Cat{
    int abilityDuration;

    public LogisticsMan(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck, ArrayList<String> statistics) {
        super(colour, currHP, maxHP, attackPower, defencePower, luck, statistics);
    }
    public void LogisticsATK(){ //Increase attack power for following 2 attacks
        this.abilityDuration = 2;//this method does NOT stack for balance reasons //TODO: should make that clear ingame
        this.attackPower+=2;
        //"Logiskissa attack power increased by 2 for 2 attacks!"
    }
    @Override
    public void attack(Cat catToAttack){//Overriding parent attack method to deal with special
        if(abilityDuration > 0){
            abilityDuration=-1;
            if(abilityDuration<=0){
                attackPower=-2;
            }
        }
        super.attack(catToAttack);//TODO : test if this shizzle works, i think so
    }
}
