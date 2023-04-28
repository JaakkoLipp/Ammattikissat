package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class PipeMan extends Cat {
    //attributes
    int attackPowerDecrease = 1;
    int defencePowerIncrease = 1;
    //constructor
    public PipeMan(String colour) {
        super(colour, 24, 24, 6, 8, 0);
    }

    //actions
    @Override
    public String uniqueAbility() {
        if (this.attackPower > attackPowerDecrease) {
            this.attackPower -= attackPowerDecrease;
            this.defencePower += defencePowerIncrease;
        }

        return ( "Käytit oman kyvyn. Sait " + defencePowerIncrease + "pistettä puollustusta lisää. (Ennen " + (this.defencePower-defencePowerIncrease) + ", nyt)" + this.defencePower + ". Menetit " + attackPowerDecrease + " verran hyökkäys voimaa. (Ennen " + this.attackPower+attackPowerDecrease + ", nyt " + this.attackPower + ").");
    }
    //getters

    public int getAttackPowerDecrease() {
        return attackPowerDecrease;
    }

    public int getDefencePowerIncrease() {
        return defencePowerIncrease;
    }
}