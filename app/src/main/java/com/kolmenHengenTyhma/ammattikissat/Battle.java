package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class Battle {
    private Random random = new Random();
    private Cat c1, c2;
    private boolean c1HasRun = false,c2HasRun = false;
    private computerOpponent opponent;
    // CONST
    public Battle(Cat c1) {
        this.opponent = new computerOpponent();
        this.c2 = opponent.getCat();

    }



    public void c1_attack(){
        if (c2.defend()){
            System.out.println("Hyökkäys estetty.");
            return;
        } else {
            c2.takeDMG(c1.getAttackDamage()-(c2.getDefencePower() / 2));//Damage calculation
        }
    }

    public void c1_defend(){
        c1.defend();
    }

    public void c1_ability(){
        c1.uniqueAbility();

    }

    public void c1_run(){
        c1HasRun = true;
    }

    public void computerAction(){
        int action = opponent.getAction();//returns: 0=error, 1=attack, 2=defend, 3=ability, 4=run

        if (action == 1){ //computer attack
            if (c1.defend()){
                System.out.println("Hyökkäys estetty.");
                return;
            } else {
                c1.takeDMG(c2.getAttackDamage()-(c1.getDefencePower() / 2));//Damage calculation
            }

        } else if (action == 2){ //computer defend
            c2.defend();

        } else if (action == 3){ //computer ability
            c2.uniqueAbility();

        } else if (action == 4){ //computer run
            c2HasRun = true;

        } else if (action == 0){
            System.out.println("Virhetietokoneen valinnassa.");
        } else {
            System.out.println("Arvo valinta-alueen ulkopuolelta.");
        }
    }



    public boolean isBattleEnded(){
        boolean isBattleEnd = false;

        if (c1.getCurrHP() <= 0 || c2.getCurrHP() <= 0 || c1HasRun || c2HasRun ){
            isBattleEnd = true;
        }

        return  isBattleEnd;
    }

    public Cat getPlayerCat() {
        return c1;
    }
}
