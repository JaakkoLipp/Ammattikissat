package com.kolmenHengenTyhma.ammattikissat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.kolmenHengenTyhma.ammattikissat.Battle;
import com.kolmenHengenTyhma.ammattikissat.CarMan;
import com.kolmenHengenTyhma.ammattikissat.Cat;
import com.kolmenHengenTyhma.ammattikissat.LogisticsMan;
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
    private int preBattleAttack, preBattleDefence;
    private double preBattleLuck;
    private boolean gameIsRunning;
    private boolean playerHasClicked; //used for checking if player has interacted in current game
    private ScrollView swBattleLog;



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

    public void scrollBattleLog(){
        swBattleLog.post(new Runnable() {
            @Override
            public void run() {
                swBattleLog.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    public void battleInitialisation(){
        playerCat = ProfessionalSchool.getInstance().chooseCat(ProfessionalSchool.getInstance().getSelectedCatPos());
        tvBattleLog.setText("Ladattu kissa: " + playerCat.getName() + "\n");
        pbOwnHealth.setProgress(playerCat.getCurrHPinPercentage());
        gameIsRunning = false;
        playerHasClicked = false;

        if (playerCat.getCurrHP() == 0){
            tvBattleLog.append("Sinulla ei ole yhtään hp:ta ja taistelu ei voi alkaa\n");
        } else {
            ProfessionalSchool professionalSchool = ProfessionalSchool.getInstance();
            tvBattleLog.append("Taistelu numero: " + professionalSchool.getBattleNumber() + "\n");
            currentBattle = new Battle(playerCat);
            pbOpponentHealth.setProgress(currentBattle.getOpponentCatHpInPercentage());
            tvOpponentName.setText("Vastustaja: " + currentBattle.getOpponentCatName());
            tvOpponentStats.setText(currentBattle.getOpponentStats());
            ivOpponentImage.setImageResource(currentBattle.getOpponentCatPicID());
            preBattleAttack = playerCat.getAttackPower();
            preBattleDefence = playerCat.getDefencePower();
            preBattleLuck = playerCat.getLuck();
        }

    }



    public int endOfTurnHandling(){
        scrollBattleLog();
        pbOwnHealth.setProgress(playerCat.getCurrHPinPercentage());
        pbOpponentHealth.setProgress(currentBattle.getOpponentCatHpInPercentage());
        tvOpponentStats.setText(currentBattle.getOpponentStats());

        //check if game ended
        if (currentBattle.isBattleEnded()){
            gameIsRunning = false;
            playerHasClicked = true; //if battle ends after player turn, player must have clicked, required as battle count does not increase after wins without this
            endOfGame();
            return 0;
        }

        //if not ended, do computer turn
        tvBattleLog.append(currentBattle.computerAction()+"\n");
        pbOwnHealth.setProgress(playerCat.getCurrHPinPercentage());
        pbOpponentHealth.setProgress(currentBattle.getOpponentCatHpInPercentage());
        tvOpponentStats.setText(currentBattle.getOpponentStats());

        tvBattleLog.append("\n");
        scrollBattleLog();


        //check if game ended
        if (currentBattle.isBattleEnded()){
            gameIsRunning = false;
            playerHasClicked = true; //player must have clicked to get to here, required as battle count does not increase after wins without this
            endOfGame();
            return 0;
        }


        return 0;
    }

    public void endOfGame(){
        tvBattleLog.append("Peli päättyi. \n");
        playerCat = currentBattle.getPlayerCat();
        if (playerHasClicked) {
            playerCat.increaseMatchcount();
            ProfessionalSchool.getInstance().increaseBattleNumber();


            int matchEndReason = currentBattle.getMatchEndStatus(); // 1 = player ran, 2 = computer ran, 3 = player died, 4 = computer died, 0= error

            if (matchEndReason == 1){
                tvBattleLog.append("Juoksit pois ja hävisit\n");
                playerCat.increaseLossCount();
            } else if (matchEndReason == 2){
                tvBattleLog.append("Vastustaja juoksi pois ja voitit. Peli päättyi.\n");
                playerCat.increaseWinCount();
            } else if (matchEndReason == 3){
                tvBattleLog.append(("Kisseltä loppu elämäpisteet. Hävisit.\n"));
                playerCat.increaseLossCount();
            } else if (matchEndReason == 4){
                tvBattleLog.append("Vastustajalta loppui elämäpisteet. Voitit.\n");
                playerCat.increaseWinCount();
            } else if (matchEndReason == 5){
                System.out.println("error from battle.java");
            } else {
                System.out.println("Error from battlescreen.java");
            }
        }


        //set cat changeable values back
        playerCat.setAttackPower(preBattleAttack);
        playerCat.setDefencePower(preBattleDefence);
        playerCat.setLuck(preBattleLuck);

        if (playerCat instanceof LogisticsMan){
            ((LogisticsMan) playerCat).setAbilityDuration(0);
        }

        if (playerCat instanceof CarMan){
            ((CarMan) playerCat).setAbilityDuration(0);
        }

        if (gameIsRunning){
            playerCat.increaseLossCount();
        }

        gameIsRunning = false;
        playerHasClicked = false;
        scrollBattleLog();



    }

    public void playerAttack(){
        if (currentBattle.isBattleEnded()){
            tvBattleLog.append("Peli on päättynyt jo.\n");
            scrollBattleLog();
        } else {
            gameIsRunning = true;
            tvBattleLog.append(currentBattle.c1_attack() + "\n");
            tvOpponentStats.setText(currentBattle.getOpponentStats());
            endOfTurnHandling();
        }
    }

    public void playerDefence(){
        if (currentBattle.isBattleEnded()){
            tvBattleLog.append("Peli on päättynyt jo.\n");
            scrollBattleLog();
        } else {
            gameIsRunning = true;
            playerHasClicked = true;
            tvBattleLog.append(currentBattle.c1_defend() + "\n");
            endOfTurnHandling();
        }
    }

    public void playerAbility(){
        if (currentBattle.isBattleEnded()){
            tvBattleLog.append("Peli on päättynyt jo.\n");
            scrollBattleLog();
        } else {
            gameIsRunning = true;
            playerHasClicked = true;
            tvBattleLog.append(currentBattle.c1_ability() + "\n");
            endOfTurnHandling();
        }
    }

    public void playerRun(){
        if (currentBattle.isBattleEnded()){
            tvBattleLog.append("Peli on päättynyt jo.\n");
            scrollBattleLog();
        } else {
            gameIsRunning = true;
            currentBattle.c1_run();
            playerHasClicked = true;
            tvBattleLog.append("Juoksit pois taistelusta.\n");
            endOfTurnHandling();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentOpen = true;
        pbOpponentHealth.setProgress(100);
        battleInitialisation();



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFragmentOpen = false;
        endOfGame();

    }

    @Override
    public void onPause() {
        super.onPause();
        isFragmentOpen = false;
        endOfGame();
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
        pbOpponentHealth.setVisibility(View.VISIBLE);
        pbOwnHealth.setVisibility(View.VISIBLE);

        swBattleLog = view.findViewById(R.id.swBattleLog);

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