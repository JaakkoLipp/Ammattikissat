package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Information#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Information extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Cat cat = new Cat("orangse", 20, 20, 20, 20, 20); //TODO: Add custom cat getting

    public Information() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Information.
     */
    // TODO: Rename and change types and number of parameters
    public static Information newInstance(String param1, String param2) {
        Information fragment = new Information();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        TextView tvCatName = view.findViewById(R.id.tvCatName); //initialize fragment elements
        TextView tvCatEverything = view.findViewById(R.id.tvCatEverything);
        TextView tvWinLoss = view.findViewById(R.id.twWinLoss);
        ImageView ivprofie = view.findViewById(R.id.ivCatPhoto); //TODO: add changing cat pircure

        String name = "place holder"; //initialize all variables
        String colour = cat.getColour();
        int currentHP = cat.getCurrHP();
        int maxHP = cat.getMaxHP();
        int attackPower = cat.getAttackPower();
        int defencePower = cat.getDefencePower();
        double luck = cat.getLuck();
        int wins = cat.getWonMatches();
        int losses = cat.getLostMatches();
        int matches = cat.getMatches();

        //TODO: make a if else tree which sets the name of the cat based on the instance type

        //TODO: implement training button


        tvCatName.setText(name + "aAAAAAaa"); //TODO: once cat integration works, remove aAAAAAaa
        tvWinLoss.setText("Voitot/Häviöt: " + wins + "/" + losses);
        tvCatEverything.setText("Väri: " + colour + "\nTaistellut ottelut: " + matches + "\nElämä pisteet: " + currentHP + "/" + maxHP + "\nHyökkäysvoima: " + attackPower + "\nPuolustus voima:" + defencePower + "\nOnni: " + "luck");
        return view;
    }
}