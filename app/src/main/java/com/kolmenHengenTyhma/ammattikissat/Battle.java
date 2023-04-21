package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class Battle {
    private Random random = new Random();
    private Cat c1;
    private Cat c2;
    // CONST
    public Battle() {
        // stateless instance?
    }
    public Cat battle(Cat c1, Cat c2){
        // TODO: battle logic? Make biased rng based on the attack of töiCissa?

        int RNGwinner = random.nextInt(2);

        if(RNGwinner == 0){
            // TODO: public atk ok?
            c2.takeDMG(c1.attackPower-c2.defencePower);
            return c1;
        }else{
            c1.takeDMG(c2.attackPower-c1.defencePower);
            return c2;
        }
    }
}
