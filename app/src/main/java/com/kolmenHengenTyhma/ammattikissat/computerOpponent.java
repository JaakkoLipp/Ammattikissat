package com.kolmenHengenTyhma.ammattikissat;

import java.util.Random;

public class computerOpponent {
    //attributes
    Cat cat;
    private double propabilityAttack = 0.5; //all probabilities must sum to 1
    private double propabilityDefend = 0.3;
    private double propabilityAbility = 0.15;
    private double propabilityRun = 0.05;

    public computerOpponent(){
        Random r = new Random();
        int randomInt = r.nextInt(5);
        switch (randomInt) {
            case 0:
                this.cat = new CarMan("Vastustaja orangse");
                break;
            case 1:
                this.cat = new ElectricianMan("Vastustaja orangse");
                break;
            case 2:
                this.cat = new LogisticsMan("Vastustaja orangse");
                break;
            case 3:
                this.cat = new PipeMan("Vastustaja orangse");
                break;
            case 4:
                this.cat = new RaksaMan("Vastustaja orangse");
                break;
        }


        this.cat = new ElectricianMan("Vastustaja orangse");
    }

    //actions
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
    public String getAbilityMessageBasedOnCat(){
        if (cat instanceof ElectricianMan){
            int takenDamage = ((ElectricianMan) cat).getTakeDamage();
            int increasedPower = ((ElectricianMan) cat).getIncreasePower();
            return ("Vastustaja käytti oman kyvyn. Vastustaja otti " + takenDamage + " pistettä vahinkoa ja hyökkäysvoima nousi " + increasedPower + " verran. (Ennen " + (cat.getAttackPower()-increasedPower) + ").");
        } else if (cat instanceof PipeMan){
            int attackPowerDecrease = ((PipeMan) cat).getAttackPowerDecrease();
            int defencePowerIncrease = ((PipeMan) cat).getDefencePowerIncrease();
            int defencePower = cat.getDefencePower();
            int attackPower = cat.getAttackPower();
            return ("Vastustaja käytti oman kyvyn. Vastustaja sai " + defencePowerIncrease + "pistettä puollustusta lisää. (Ennen " + (defencePower-defencePowerIncrease) + ", nyt)" + defencePower + ". Vastustaja menetti " + attackPowerDecrease + " verran hyökkäys voimaa. (Ennen " + attackPower+attackPowerDecrease + ", nyt " + attackPower + ").");
        } else if (cat instanceof CarMan){
            double catLuck = cat.getLuck();
            int abilityDurationIncrease = ((CarMan) cat).getAbilityDurationIncrease();
            double luckIncrease = ((CarMan) cat).getLuckIncrease();
            return ("Vastustaja käytti oman kyvyn. Hänen tuuri on noussut arvoon" + catLuck + "(Ennen " + (catLuck-luckIncrease) + "). Tämä kestää " + abilityDurationIncrease + " vuoroa.");
        } else if (cat instanceof LogisticsMan){
            int abilityDurationTime = ((LogisticsMan) cat).getAbilityDurationTime();
            int abilityPowerIncrease = ((LogisticsMan) cat).getAbilityPowerIncrease();
            int catAttackPower = cat.getAttackPower();
            return ("Vastustaja käytti oman kyvyn. " + abilityDurationTime + " vuoron ajaksi vastustajan hyökkäysvoima on " + catAttackPower + ".korkeampi (Hyökkäysvoima ennen: " + (catAttackPower-abilityPowerIncrease) + ")(Abilityn pituue ei voi kasvaa yli kahden useammalla käytöllä.)");
        } else if (cat instanceof RaksaMan){
            int currentHP = cat.getCurrHP();
            int healtBeforeheal = ((RaksaMan) cat).getHpBeforeHeal();
            return ("Vastustaja käytti oman kyvyn ja terveytti kissaansa(Max 4 HP). Hp oli " + healtBeforeheal + " ja on nyt " + currentHP + ".");
        } else {
            return ("Vastustajan Kissalla ei ole tyyppiä / Virhe viestin haussa computerOpponen.java:ssa");

        }
    }

    //getters
    public Cat getCat() {
        return cat;
    }
    public String getStats(){
        return ("Väri: " + cat.getColour() + "\n\nElämä pisteet: " + cat.getCurrHP() + "/" + cat.getMaxHP() + "\n\nHyökkäysvoima: " + cat.getAttackPower() + "\n\nPuolustus voima:" + cat.getDefencePower() + "\n\nOnni: " + cat.getLuck());
    }
    public String getCatName(){
        return cat.getName();
    }

    public int getCatPicID(){
        return cat.getCatPic();
    }

    public int getCatHpInPercentage(){
        return cat.getCurrHPinPercentage();
    }



}
