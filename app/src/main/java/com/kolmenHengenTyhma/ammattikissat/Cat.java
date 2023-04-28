package com.kolmenHengenTyhma.ammattikissat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Cat implements Serializable {
    // Attributes
    protected int attackPower;
    protected int defencePower;
    protected String colour;
    protected int currHP;
    protected int maxHP;
    protected boolean isInDefence = false;
    protected double luck; //LUCK is calculated in points, should be between 0 and 10
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
    public String uniqueAbility() {
        return ("how did you get here?");
    }
    public void takeDMG(int damage){
        if(currHP > damage && damage >= 0){
            currHP -= damage;
        }else if ( currHP > damage && damage < 0){
            //does nothing if damage negative.
        } else {
            // L cat (Dead 💀)
            currHP = 0;
        }
    }
    public String getName(){
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
        int id;
        if (this instanceof ElectricianMan){
            id = R.drawable.sahkissa_nobg;
        } else if (this instanceof PipeMan) {
            id = R.drawable.putkissa_nobg;
        } else if (this instanceof CarMan) {
            id = R.drawable.autokissa_nobg;
        } else if (this instanceof LogisticsMan) {
            id = R.drawable.logiskissa_nobg;
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
        // Train limit + multiplied by winned games #50
        if(2*wonMatches+1 >= trainedDays){
            // randomize the attribute to +1
            int rng= random.nextInt(3);
            if(rng == 0){
                defencePower+=1;
                System.out.println("Training attribute: "+rng);
            } else if(rng == 1){
                maxHP+=1;
                System.out.println("Training attribute: "+rng);
            }else{
                attackPower += 1;
            }
            trainedDays = trainedDays + 1;
        }
    }

    //setters
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public void setMatches(int matches) {
        this.matches = matches;
    }
    public void increaseMatchcount(){
        this.matches += 1;
    }
    public void increaseWinCount(){
        this.wonMatches += 1;
    }
    public void increaseLossCount(){
        this.lostMatches += 1;
    }
    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }
    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }
    public String setToDefence(){
        if (isInDefence){
            return ("Olet jo puollustuksessa.");
        } else {
            isInDefence = true;
            return ("Asetit itsesi puollustukseen. Vastustaja ei pysty hyökkäämään seuraavalla vuorolla.");
        }
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public void setLuck(double luck) {
        this.luck = luck;
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

    public int getTrainedDays() {
        return trainedDays;
    }
}
