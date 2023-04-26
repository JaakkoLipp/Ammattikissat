package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: STORAGE & MAIN FUNCTIONALITY
public class ProfessionalSchool {
    private static ProfessionalSchool school = null;

    // Cat storage list
    private HashMap<Integer, Cat> catStorageList = new HashMap<Integer, Cat>();
    private int orderNumberCat = 0;

    //Singleton
    private ProfessionalSchool() {
        // TODO: temp cats remove
        ElectricianMan ELMAN = new ElectricianMan("Orange");
        PipeMan POIPEMAN = new PipeMan("Not Orange");
        CarMan REMONGER = new CarMan("Black");
        POIPEMAN.takeDMG(10);
        REMONGER.takeDMG(3);
        catStorageList.put(0,ELMAN);
        catStorageList.put(1, POIPEMAN);
        catStorageList.put(2,REMONGER);
    }
    public static ProfessionalSchool getInstance() {
        if (school == null) {
            school = new ProfessionalSchool();
        }
        return school;
    }

    //Methods
    public HashMap<Integer, Cat> getCatStorageList(){
        return catStorageList;
    }

    public Cat chooseCat(int orderNumber){
        return catStorageList.get(orderNumber);
    }
    public void trainCat(Cat cat){
        cat.attackPower+=1;
    }
    public void addCat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck, ArrayList<String> statistics){
        Cat newCat;
        catStorageList.put(orderNumberCat, null);
        orderNumberCat+=1;
    }
    public void healCat(int orderNumber){
        Cat catToHeal = chooseCat(orderNumber);
        catToHeal.heal();
    }
}

