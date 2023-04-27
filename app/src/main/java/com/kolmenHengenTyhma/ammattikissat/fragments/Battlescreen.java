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
import android.widget.Toast;

import com.kolmenHengenTyhma.ammattikissat.Battle;
import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.ProfessionalSchool;
import com.kolmenHengenTyhma.ammattikissat.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Battlescreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Battlescreen extends Fragment {
    private int test = 0; //TODO: remove after testing
    private Boolean btAttackPressed = false,btDefendPressed = false,btAbilityPressed = false,btRunPressed = false;
    private Cat playerCat = new Cat("orange", 10, 10, 10, 10, 5); //TODO: get player chosen cat to battle screen
    private boolean isFragmentOpen;
    private Button btAttack, btDefend, btAbility, btRun;
    private TextView tvOpponentName, tvOpponentStats, tvBattleLog;
    private ImageView ivOpponentImage;
    private ProgressBar pbOpponentHealth, pbOwnHealth;
    private Cat playerCat;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Battlescreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Battlescreen.
     */
    // TODO: Rename and change types and number of parameters
    public static Battlescreen newInstance(String param1, String param2) {
        Battlescreen fragment = new Battlescreen();
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

    public void battleLoop(){
        Battle currentBattle = new Battle();
        do{
            if (btAttackPressed){ //player actions
                currentBattle.c1_attack();
                currentBattle.computerAction();
            } else if (btDefendPressed){
                currentBattle.c1_defend();
                currentBattle.computerAction();
            } else if (btAbilityPressed){
                currentBattle.c1_ability();
                currentBattle.computerAction();
            } else if (btRunPressed){
                currentBattle.c1_run();
                currentBattle.computerAction();
            }

            if (currentBattle.isBattleEnded()){
                //TODO: end battle(currently battle ends when view ends)
            }

        } while (isFragmentOpen); //TODO: remove while true

        playerCat = currentBattle.getPlayerCat(); //set the player cat to be the one from battle after battle
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentOpen = true;
        tvBattleLog.append("1");
        playerCat = ProfessionalSchool.getInstance().chooseCat(ProfessionalSchool.getInstance().getSelectedCatPos());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFragmentOpen = false;
        tvBattleLog.append("0");

    }

    @Override
    public void onPause() {
        super.onPause();
        isFragmentOpen = false;
        tvBattleLog.append("0");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_battlescreen, container, false);

        btAttack = view.findViewById(R.id.btAttackButton);
        btDefend = view.findViewById(R.id.btDefendButton);
        btAbility = view.findViewById(R.id.btAbilityButton);
        btRun = view.findViewById(R.id.btRunButton);

        tvOpponentName = view.findViewById(R.id.tvOpponentName);
        tvOpponentStats = view.findViewById(R.id.tvOpponentStats);
        tvBattleLog = view.findViewById(R.id.tvBattleLog);

        ivOpponentImage = view.findViewById(R.id.ivOpponentImage);

        pbOpponentHealth = view.findViewById(R.id.pbOpponentHealth);
        pbOwnHealth = view.findViewById(R.id.pbOwnHealth);

        btAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btAttackPressed = true;
            }
        });
        btDefend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btDefendPressed = true;
            }
        });
        btAbility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btAbilityPressed = true;
            }
        });
        btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                btRunPressed = true;
            }
        });




        return view;
    }
}