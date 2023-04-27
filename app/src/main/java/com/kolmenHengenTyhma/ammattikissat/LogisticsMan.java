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
    public String uniqueAbility(){ //Increase attack power for following 2 attacks
        int abilityDurationTime = 2;
        int abilityPowerIncrease = 2;

        this.abilityDuration = abilityDurationTime;//this method does NOT stack for balance reasons //TODO: should make that clear ingame
        this.attackPower+=abilityPowerIncrease;
        //"Logiskissa attack power increased by 2 for 2 attacks!"

        return ( "Käytit oman kyvyn. " + abilityDurationTime + " vuoron ajaksi hyökkäys voimasi on " + abilityPowerIncrease + " korkeampi (Hyökkäysvoima nyt: " + this.attackPower + ", hyökkäysvoima ennen: " + (this.attackPower-abilityPowerIncrease) + ")(Abilityn pituue ei voi kasvaa yli kahden useammalla käytöllä.)");
    }
}
