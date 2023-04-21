package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.Random;

public class Cat {
    // Attributes
    private int attackPower;
    private int defencePower;
    private String colour;
    private int currHP;
    private int maxHP;
    public double luck;
    private ArrayList<String> matchHistory = new ArrayList<String>();
    // Store matches in order with format "W"/"L"
    private int trainedDays=0;


    //constructor
    public Cat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck, ArrayList<String> matchHistory) {
        this.colour = colour;
        this.currHP = currHP;
        this.maxHP = maxHP;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.luck = luck;
        this.matchHistory = matchHistory;
    }
    public void attackAbility(){
        // TODO: implement attack ability
    }
    public void heal() {
        currHP=maxHP;
    }
    public void takeDMG(int damage){
        //TODO: LUCK?
        if(currHP > damage){
            currHP-=damage;
        }else if(currHP<=damage){
            // L cat (Dead 💀)
            currHP=0;
        }
    }
    public int getDefencePower() {
        return defencePower;
    }
    public int getAttackPower() {
        return attackPower;
    }
}
