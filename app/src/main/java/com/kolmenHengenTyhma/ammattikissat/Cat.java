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
    protected int matches;
    protected int wonMatches;
    protected int lostMatches;
    protected int trainedDays;
    private Random random = new Random();

    //constructor
    public Cat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck) {
        this.colour = colour;
        this.currHP = currHP;
        this.maxHP = maxHP;

        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.luck = luck;

        matches = 0;
        wonMatches = 0;
        lostMatches = 0;
        this.trainedDays = 0;
    }

    //actions
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
    public String getName(){
        // TODO: fix patent solutions
        String name = "Not Found";
        if (this instanceof ElectricianMan){
            name = "Sähkökissa";
        } else if (this instanceof PipeMan) {
            name = "LVI-kissa";
        } else if (this instanceof CarMan) {
            name = "Autokissa";
        } else if (this instanceof LogisticsMan) {
            name = "Logistiikkakissa";
        } else if (this instanceof RaksaMan) {
            name = "Raksakissa";
        } else {
            name = "TöiKissa";
        }
        return name;
    }
    public int getCatPic(){
        // TODO: fix patent solutions
        int id;
        if (this instanceof ElectricianMan){
            id = R.drawable.sahkissa_nobg;
        } else if (this instanceof PipeMan) {
            id = R.drawable.putkissa_nobg;
        } else if (this instanceof CarMan) {
            id = R.drawable.autokissa_nobg;
        } else if (this instanceof LogisticsMan) {
            id = R.drawable.autokissa_nobg;
        } else if (this instanceof RaksaMan) {
            id = R.drawable.raksakissa_nobg;
        } else {
            id = R.drawable.raksakissa_nobg;
        }
        return id;
    }
    public void heal(){
        currHP = maxHP;
    }
    public void train(){
        attackPower = attackPower + 1;
    }

    //setters
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public void setMatches(int matches) {
        this.matches = matches;
    }
    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }
    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }

    //getters
    public int getMatches() {
        return matches;
    }
    public int getWonMatches() {
        return wonMatches;
    }
    public int getLostMatches() {
        return lostMatches;
    }
    public double getLuck() {
        return luck;
    }
    public String getColour() {
        return colour;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getDefencePower() {
        return defencePower;
    }
    public int getAttackPower() {
        return attackPower;
    }

    public int getCurrHP(){
        return currHP;
    }
    public int getCurrHPinPercentage(){
        return (currHP*100/maxHP*100)/100;
    }
}
