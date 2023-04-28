package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ProfessionalSchool {
    //attributes
    private static ProfessionalSchool school = null;

    // Cat storage list
    private HashMap<Integer, Cat> catStorageList = new HashMap<Integer, Cat>();
    private int orderNumberCat = 0;
    private int selectedCatPos;
    private int battleNumber = 1;

    //Singleton
    private ProfessionalSchool() {
        // TODO: temp cats remove
        ElectricianMan ELMAN = new ElectricianMan("Oranssi");
        PipeMan POIPEMAN = new PipeMan("Not Oranssi");
        RaksaMan REMONGER = new RaksaMan("Vaalea");
        CarMan CARCAT = new CarMan("Tosi tumma");
        POIPEMAN.takeDMG(5);
        CARCAT.takeDMG(10);
        catStorageList.put(0,ELMAN);
        catStorageList.put(1, POIPEMAN);
        catStorageList.put(2,REMONGER);
        catStorageList.put(3,CARCAT);
        orderNumberCat = 4;

    }
    public static ProfessionalSchool getInstance() {
        if (school == null) {
            school = new ProfessionalSchool();
        }
        return school;
    }

    //Actions
    public void trainCat(int pos){
        Cat cat = chooseCat(pos);
        cat.train();
    }

    public void healCat(int pos){
        Cat catToHeal = chooseCat(pos);
        catToHeal.heal();
    }

    public void increaseBattleNumber(){
        battleNumber = battleNumber + 1;
    }
    public void addNewRandomCat(){
        Cat newCat = new LogisticsMan("Black");

        Random r = new Random();
        int randomInt = r.nextInt(5);
        switch (randomInt) {
            case 0:
                newCat = new CarMan("Kirkkaan oranssi");
                break;
            case 1:
                newCat = new ElectricianMan("sininen");
                break;
            case 2:
                newCat = new LogisticsMan("Mustavalkoinen");
                break;
            case 3:
                newCat = new PipeMan("Vihreä");
                break;
            case 4:
                newCat = new RaksaMan("Valkoinen");
                break;
        }


        catStorageList.put(orderNumberCat, newCat);
        orderNumberCat+=1;
        System.out.println("Kissa lisätty + " + catStorageList.size());


    }

    //Getters
    public HashMap<Integer, Cat> getCatStorageList(){
        return catStorageList;
    }
    public Cat chooseCat(int orderNumber){
        return catStorageList.get(orderNumber);
    }
    public int getSelectedCatPos() {
        return selectedCatPos;
    }
    public void setSelectedCatPos(int selectedCatPos) {
        this.selectedCatPos = selectedCatPos;
    }

    public int getBattleNumber() {
        return battleNumber;
    }
}

