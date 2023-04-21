package com.kolmenHengenTyhma.ammattikissat;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: STORAGE & MAIN FUNCTIONALITY
public class ProfessionalSchool {
    // cat battler
    private Battle Battle = new Battle();
    // cat storage list
    private HashMap<Integer, String> catStorageList = new HashMap<Integer, String>();
    private int orderNumberCat = 0;

    public ProfessionalSchool() {
        //TODO amisConstr
    }

    // methods

    public HashMap<Integer, String> getCatStorageList(){
        return catStorageList;
    }
    public Cat chooseCat(int orderNumber){
        //TODO: return cat from storage
        return null;
    }
    public void trainCat(){
        //TODO: stats++
        return;
    }
    public void addCat(String colour, int currHP, int maxHP, int attackPower, int defencePower, double luck, ArrayList<String> statistics){
        Cat newCat;
        catStorageList.put(orderNumberCat, null);
    }
    public void healCat(int orderNumber){
        Cat catToHeal = chooseCat(orderNumber);
        catToHeal.heal();
    }
}

