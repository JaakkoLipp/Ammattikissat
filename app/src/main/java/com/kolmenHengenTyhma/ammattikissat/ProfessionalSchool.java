package com.kolmenHengenTyhma.ammattikissat;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    //catlist file handling
    public void saveCats(Context context){
        try {
            ObjectOutputStream catWriter = new ObjectOutputStream(context.openFileOutput("cats.data", Context.MODE_PRIVATE));
            catWriter.writeObject(catStorageList);
            catWriter.close();
        } catch (IOException e) {
            System.out.println("Rakettien tallentaminen ei onnistunut");
        }

    }

    public void loadCats(Context context){
        try {
            ObjectInputStream catReader = new ObjectInputStream(context.openFileInput("rockets.data"));
            catStorageList = (HashMap<Integer, Cat>) catReader.readObject();
            catReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Rakettien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Rakettien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Rakettien lukeminen ei onnistunut");
            e.printStackTrace();

        }
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

