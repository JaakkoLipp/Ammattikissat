package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;

public class RaksaMan extends Cat{

    //constructor
    public RaksaMan(String colour) {
        super(colour, 20, 20, 4, 6, 1);
    }

    //actions
    @Override
    public String uniqueAbility(){//Heal!
        int healAmmount = 4;
        int hpBeforeHeal = this.currHP;
        this.currHP += healAmmount;
        if(currHP>=maxHP) {;
            this.currHP = this.maxHP;
        }

        return ("Käytit oman kyvyn. Terveytit kissasi(Max 4 hp). Elämäpisteesi on nyt " + currHP + ", ennen " + hpBeforeHeal + ".");
    }

}
