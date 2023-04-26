package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.Random;


public class Cat {
    // Attributes
    protected int attackPower;
    protected int defencePower;
    protected String colour;
    protected int currHP;
    protected int maxHP;
    protected boolean isInDefence = false;
    protected double luck;//LUCK is calculated in points, should be between 0 and 10
    protected ArrayList<String> matchHistory = new ArrayList<String>();
    // Store matches in order with format "W"/"L"
    protected int trainedDays;
    //TODO: changed everything private -> protected so subclass abilities can access stats, luck protected as well

    private Random random = new Random();
    //constructor
    public Cat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck) {
        this.colour = colour;
        this.currHP = currHP;
        this.maxHP = maxHP;

        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.luck = luck;

        this.matchHistory = matchHistory;
        this.trainedDays = 0;
    }
    public int getAttackDamage() {
        int damage;
        if((random.nextInt(10)+this.luck) > 6){ // (33% + luck) = chance of critical hit
            damage = attackPower + 2 ;// Critical hit deals +1 damage
        }else{
            damage = attackPower;
        }

        return damage;
    }

    public boolean defend(){
        if (isInDefence){
            this.isInDefence = false;
            return true;
        } else {
            return false;
        }
    }

    public void uniqueAbility() {
        //TODO: default unique ability?
    }
    public void takeDMG(int damage){
        if(currHP > damage){
            currHP -= damage;
        }else{
            // L cat (Dead 💀)
            currHP = 0;
        }
    }
    public void heal() {//General restore health -method, NOT an ability!
        currHP = maxHP;
    }

    public int getDefencePower() {
        return defencePower;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public boolean getIsInDefence(){
        return isInDefence;
    }

    public int getCurrHP(){
        return currHP;
    }
}
