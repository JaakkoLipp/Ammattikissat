package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.HashMap;


public class ProfessionalSchool {
    //attributes
    private static ProfessionalSchool school = null;

    // Cat storage list
    private HashMap<Integer, Cat> catStorageList = new HashMap<Integer, Cat>();
    private int orderNumberCat = 0;
    private int selectedCatPos;

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

    }
    public static ProfessionalSchool getInstance() {
        if (school == null) {
            school = new ProfessionalSchool();
        }
        return school;
    }

    //Actions
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
}

