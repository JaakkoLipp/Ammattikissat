package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class computerOpponent {
    Cat cat;
    private double propabilityAttack = 0.5; //all probabilities must sum to 1
    private double propabilityDefend = 0.3;
    private double propabilityAbility = 0.1;
    private double propabilityRun = 0.1;

    public computerOpponent(){
        this.cat = new Cat("orange", 10, 10, 10, 10, 5);

    }

    public Cat getCat() {
        return cat;
    }

    public int getAction(){//returns: 0=error, 1=attack, 2=defend, 3=ability, 4=run
        Random r = new Random();
        double randomDouble = r.nextDouble();

        if (randomDouble < this.propabilityAttack){
            return 1;
        } else if(randomDouble < this.propabilityAttack + this.propabilityDefend) {
            return 2;
        } else if(randomDouble <this.propabilityAttack + this.propabilityDefend + this.propabilityAbility){
            return 3;
        } else {
            return 4;
        }
    }
}
