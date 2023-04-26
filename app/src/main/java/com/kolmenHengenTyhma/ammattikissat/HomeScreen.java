package com.kolmenHengenTyhma.ammattikissat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kolmenHengenTyhma.ammattikissat.fragments.CatRecycler;
import com.kolmenHengenTyhma.ammattikissat.fragments.Information;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button fragmentCRB = findViewById(R.id.catRecyclerButton);
        Button fragmentInfoB = findViewById(R.id.informationButton);
        fragmentCRB.setOnClickListener(listener);
        fragmentInfoB.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            Fragment fragment;
            switch(view.getId()){
                case R.id.catRecyclerButton:
                    fragment = new CatRecycler();break;
                case R.id.informationButton:
                    fragment = new Information();break;
                default:
                    fragment = new CatRecycler();break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
    };
}