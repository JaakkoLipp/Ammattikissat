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
    private Cat playerCat;
    private boolean isFragmentOpen;
    private Button btAttack, btDefend, btAbility, btRun;
    private TextView tvOpponentName, tvOpponentStats, tvBattleLog;
    private ImageView ivOpponentImage;
    private ProgressBar pbOpponentHealth, pbOwnHealth;
    private Battle currentBattle;



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

    public void battleInitialisation(){

        ProfessionalSchool professionalSchool = ProfessionalSchool.getInstance();
        professionalSchool.increaseBattleNumber();
        tvBattleLog.setText("Taistelu numero: " + professionalSchool.getBattleNumber() + "\n");
        playerCat = ProfessionalSchool.getInstance().chooseCat(ProfessionalSchool.getInstance().getSelectedCatPos());
        tvBattleLog.append("Ladattu kissa: ");
        Battle currentBattle = new Battle(playerCat);
        tvOpponentName.setText("ASeta opponensi nimi tähän"); //TODO: get name with function
        tvOpponentStats.setText(currentBattle.getOpponentStats());
        //ivOpponentImage.setImageIcon(); //TODO: get picture
    }



    public int endOfTurnHandling(){
        //check if game ended
        if (currentBattle.isBattleEnded()){
            endOfGame();
            return 0;
        }

        //if game did not end do computer turn

        //check if game ended


        return 0;
    }

    public void endOfGame(){


    }

    public void playerAttack(){
        tvBattleLog.append(currentBattle.c1_attack() + "\n");
        tvOpponentStats.setText(currentBattle.getOpponentStats());
        endOfTurnHandling();

    }

    public void playerDefence(){
        tvBattleLog.append(currentBattle.c1_defend());
        endOfTurnHandling();

    }

    public void playerAbility(){
        tvBattleLog.append(currentBattle.c1_ability() + "\n");
        endOfTurnHandling();
    }

    public void playerRun(){
        currentBattle.c1_run();
        tvBattleLog.append("Juoksit pois taistelusta.\n");
        endOfTurnHandling();
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentOpen = true;
        battleInitialisation();



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFragmentOpen = false;

    }

    @Override
    public void onPause() {
        super.onPause();
        isFragmentOpen = false;
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
                playerAttack();
            }
        });
        btDefend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                playerDefence();
            }
        });
        btAbility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                playerAbility();
            }
        });
        btRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                playerRun();
            }
        });




        return view;
    }
}