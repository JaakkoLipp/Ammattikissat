package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kolmenHengenTyhma.ammattikissat.CarMan;
import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.ElectricianMan;
import com.kolmenHengenTyhma.ammattikissat.LogisticsMan;
import com.kolmenHengenTyhma.ammattikissat.PipeMan;
import com.kolmenHengenTyhma.ammattikissat.ProfessionalSchool;
import com.kolmenHengenTyhma.ammattikissat.R;
import com.kolmenHengenTyhma.ammattikissat.RaksaMan;

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
    private TextView tvCatName;
    private TextView tvCatEverything;
    private ProgressBar currHP;
    private View view;
    private TextView tvWinLoss;
    private ImageView ivprofile;
    private Button healButton;
    private Button trainButton;
    private String name = "place holder";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Cat cat = new Cat("orangse", 20, 20, 20, 20, 20); //this is a base value incase of error getting cat
    private String colour = cat.getColour();
    private int currentHP = cat.getCurrHP();
    private int maxHP = cat.getMaxHP();
    private int attackPower = cat.getAttackPower();
    private int defencePower = cat.getDefencePower();
    private double luck = cat.getLuck();
    private int wins = cat.getWonMatches();
    private int losses = cat.getLostMatches();
    private int matches = cat.getMatches();
    private int trainingDays = cat.getTrainedDays();
    public Information() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();
        // Update the contents of the fragment's views or data here
        cat= ProfessionalSchool.getInstance().chooseCat(ProfessionalSchool.getInstance().getSelectedCatPos());
        getCatData(cat);
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
    public void getCatData(Cat cat){
        // idk i guess this works patent
        ivprofile.setImageResource(cat.getCatPic());
        name = cat.getName();
        tvCatName.setText(name);
        colour = cat.getColour();
        currentHP = cat.getCurrHP();
        maxHP = cat.getMaxHP();
        attackPower = cat.getAttackPower();
        defencePower = cat.getDefencePower();
        luck = cat.getLuck();
        wins = cat.getWonMatches();
        losses = cat.getLostMatches();
        matches = cat.getMatches();
        trainingDays = cat.getTrainedDays();
        tvCatEverything.setText("Väri: " + colour + "\n\nTaistellut ottelut: " + matches + "\n\nElämä pisteet: " + currentHP + "/" + maxHP + "\n\nHyökkäysvoima: " + attackPower + "\n\nPuolustus voima:" + defencePower + "\n\nOnni: " + luck + "\n\nTreenatut päivät: " + trainingDays);
        tvWinLoss.setText("Voitot/Häviöt\n" + wins + "/" + losses);
        currHP.setVisibility(View.VISIBLE);
        currHP.setProgress(cat.getCurrHPinPercentage());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        cat= ProfessionalSchool.getInstance().chooseCat(ProfessionalSchool.getInstance().getSelectedCatPos());
        view = inflater.inflate(R.layout.fragment_information, container, false);

        tvCatName = view.findViewById(R.id.tvCatName); //initialize fragment elements
        tvCatEverything = view.findViewById(R.id.tvStats);
        tvWinLoss = view.findViewById(R.id.tvWL);
        ivprofile = view.findViewById(R.id.ivCatPicture);
        healButton = view.findViewById(R.id.btHeal);
        trainButton = view.findViewById(R.id.btTrain);
        currHP = view.findViewById(R.id.pbHP);
        getCatData(cat);
        healButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something when the button is clicked
                ProfessionalSchool.getInstance().healCat(ProfessionalSchool.getInstance().getSelectedCatPos());
                currHP.setProgress(cat.getCurrHPinPercentage());
                getCatData(cat);
            }
        });
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something when the button is clicked
                ProfessionalSchool.getInstance().trainCat(ProfessionalSchool.getInstance().getSelectedCatPos());
                cat.increaseTrainedDaysByOne();
                getCatData(cat);


            }
        });

        return view;
    }
}