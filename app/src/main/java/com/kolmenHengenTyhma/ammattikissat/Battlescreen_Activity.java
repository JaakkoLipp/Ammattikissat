package com.kolmenHengenTyhma.ammattikissat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Battlescreen_Activity extends AppCompatActivity {

    private boolean isViewOpen = true;
    private Boolean btAttackPressed = false,btDefendPressed = false,btAbilityPressed = false,btRunPressed = false;
    private Cat playerCat = new Cat("orange", 10, 10, 10, 10, 5); //TODO: get player chosen cat to battle screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlescreen);


        Button btAttack = findViewById(R.id.btAttack);
        Button btDefend = findViewById(R.id.btDefend);
        Button btAbility = findViewById(R.id.btAbility);
        Button btRun = findViewById(R.id.btRun);

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


        new Thread(new Runnable() {
            computerOpponent opponent = new computerOpponent();
            Cat opponentCat = opponent.getCat();
            Battle currentBattle = new Battle(playerCat, opponentCat);

            @Override
            public void run() {
                do{ //battle loop


                    if (btAttackPressed){ //player actions

                    } else if (btDefendPressed){

                    } else if (btAbilityPressed){

                    } else if (btRunPressed){

                    }

                    if (playerCat.getCurrHP() == 0){

                    } else if (opponentCat.getCurrHP() == 0){

                    } else if (currentBattle.isC1HasRun()){

                    } else if (currentBattle.isC2HasRun()){

                    }
                } while (isViewOpen);

            }
        });



    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        isViewOpen = false;
    }

}