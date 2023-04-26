package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class Battle {
    private Random random = new Random();
    private Cat c1, c2;
    private boolean c1HasRun = false,c2HasRun = false;
    // CONST
    public Battle(Cat c1, Cat c2) {
        // stateless instance?
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

    public void c2_attack(){
        if (c1.defend()){
            System.out.println("Hyökkäys estetty.");
            return;
        } else {
            c1.takeDMG(c2.getAttackDamage()-(c1.getDefencePower() / 2));//Damage calculation
        }

    }

    public void c2_defend(){
        c2.defend();
    }

    public void c2_ability(){
        c1.uniqueAbility();
    }

    public void c2_run(){
        c2HasRun = true;
    }

    public boolean isC1HasRun() {
        return c1HasRun;
    }

    public boolean isC2HasRun() {
        return c2HasRun;
    }
}
