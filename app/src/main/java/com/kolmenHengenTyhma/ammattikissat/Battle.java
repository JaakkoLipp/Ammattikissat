package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class Battle {
    //attributes
    private Random random = new Random();
    private Cat c1, c2;
    private boolean c1HasRun = false,c2HasRun = false;
    private computerOpponent opponent;


    //constructor
    public Battle(Cat c1) {
        this.c1 = c1;
        this.opponent = new computerOpponent();
        this.c2 = opponent.getCat();

    }


    //actions
    public String c1_attack(){
        int damage;
        if (c2.defend()){
            return ("Vastustaja puollusti ja esti hyökkäyksen");
        } else {
            damage = (c1.getAttackDamage()-(c2.getDefencePower() / 2));
            if (damage < 0 ){
                damage = 0;
            }
            c2.takeDMG(damage);//Damage calculation
            return ("Teit " + damage + " vahinkoa.");
        }
    }
    public String c1_defend(){
        return (c1.setToDefence());
    }
    public String c1_ability(){
        return(c1.uniqueAbility());

    }
    public void c1_run(){
        c1HasRun = true;
    }

    public String computerAction(){ //action of the computer player
        int action = 0;
        action = opponent.getAction();//returns: 0=error, 1=attack, 2=defend, 3=ability, 4=run

        if (action == 1){ //computer attack
            if (c1.defend()){
                return ("Vastustaja hyökkäsi, mutta sinä olit puollustanut.");
            } else {
                int damage = c2.getAttackDamage()-(c1.getDefencePower() / 2);
                if (damage < 0){
                    damage = 0;
                }
                c1.takeDMG(damage);//Damage calculation
                return ("Vastustaja hyökkäsi. Otit " + damage + " pistettä vaihinkoa.");
            }

        } else if (action == 2){ //computer defend
            c2.setToDefence();
            return ("Vastustaja asetti itsensä puollustamaan.");

        } else if (action == 3){ //computer ability
            c2.uniqueAbility();
            return ("Vastustaja käytti oman kyvyn.");

        } else if (action == 4){ //computer run
            c2HasRun = true;
            return ("Vastustaja juoksi pois");

        } else if (action == 0){
            return ("Virhetietokoneen valinnassa.");

        } else {
            return ("Arvo valinta-alueen ulkopuolelta.");
        }
    }


    //getters
    public boolean isBattleEnded(){
        boolean isBattleEnd = false;

        if (c1.getCurrHP() <= 0 || c2.getCurrHP() <= 0 || c1HasRun || c2HasRun ){
            isBattleEnd = true;
        }

        return  isBattleEnd;
    }
    public int getMatchEndStatus(){// 1 = player ran, 2 = computer ran, 3 = player died, 4 = computer died, 0= error
        if (c1HasRun){
            return 1;
        } else if(c2HasRun){
            return 2;
        } else if(c1.getCurrHP() == 0){
            return 3;
        } else if(c2.getCurrHP() == 0){
            return 4;
        } else {
            return 0;
        }
    }
    public Cat getPlayerCat() {
        return c1;
    }
    public String getOpponentStats(){
        return opponent.getStats();
    }
    public String getOpponentCatName(){
        return opponent.getCatName();
    }
    public int getOpponentCatPicID(){
        return opponent.getCatPicID();
    }
    public int getOpponentCatHpInPercentage(){
        return opponent.getCatHpInPercentage();
    }
}
