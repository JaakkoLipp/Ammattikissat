package com.kolmenHengenTyhma.ammattikissat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    private ProfessionalSchool professionalSchool = ProfessionalSchool.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void switchToHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
    // TODO: KEEP CODE IN MAIN MINIMAL
    // TODO: - HOME Fragments
    // TODO: - call cat info fragment swap from cat recycler selection
}