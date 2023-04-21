package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.Random;

public class Cat {
    // Attributes
    public int attackPower;
    public int defencePower;
    private String colour;
    private int currHP;
    private int maxHP;

    public double luck;
    private ArrayList<String> statistics = new ArrayList<String>();

    //constructor
    public Cat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck, ArrayList<String> statistics) {
        this.colour = colour;
        this.currHP = currHP;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.luck = luck;
        this.statistics = statistics;
    }
    public void attackAbility(){
        // TODO: implement attack ability
    }
    public void heal() {
        currHP=maxHP;
    }
    public void takeDMG(int damage){
        if(currHP > damage){
            currHP-=damage;
        }else if(currHP<=damage){
            // L cat (Dead 💀)
            currHP=0;
        }
    }
}
