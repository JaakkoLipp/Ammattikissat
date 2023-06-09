package com.kolmenHengenTyhma.ammattikissat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
    }
    public void switchToHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
    @Override
    public void onDestroy() {
        Log.d("MusicService", "onDestroy()");
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}