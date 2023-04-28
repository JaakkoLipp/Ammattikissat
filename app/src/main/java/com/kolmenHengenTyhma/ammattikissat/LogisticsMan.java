package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class LogisticsMan extends Cat{
    //atributes
    private int abilityDuration;
    private int abilityDurationTime = 2;
    private int abilityPowerIncrease = 2;
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
        return super.getAttackDamage();
    }
    @Override
    public String uniqueAbility(){ //Increase attack power for following 2 attacks

        this.abilityDuration = abilityDurationTime;//this method does NOT stack for balance reasons
        this.attackPower+=abilityPowerIncrease;
        //"Logiskissa attack power increased by 2 for 2 attacks!"

        return ("Käytit oman kyvyn. " + abilityDurationTime + " vuoron ajaksi hyökkäys voimasi on " + this.attackPower + "(Hyökkäysvoima ennen: " + (this.attackPower-abilityPowerIncrease) + ")(Abilityn pituue ei voi kasvaa yli kahden useammalla käytöllä.)");
    }

    //setters

    public void setAbilityDuration(int abilityDuration) {
        this.abilityDuration = abilityDuration;
    }

    //getter
    public int getAbilityDurationTime() {
        return abilityDurationTime;
    }

    public int getAbilityPowerIncrease() {
        return abilityPowerIncrease;
    }
}
