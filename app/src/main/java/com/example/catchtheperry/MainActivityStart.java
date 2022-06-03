package com.example.catchtheperry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivityStart extends AppCompatActivity {
    Button startButton;
    MediaPlayer grr;
    MediaPlayer song;
    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);

        startButton = findViewById(R.id.button);
        grr = MediaPlayer.create(this,R.raw.grr);
        song = MediaPlayer.create(this,R.raw.song);
        playSong();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopSong();
    }

    @Override
    protected void onResume() {
        super.onResume();
        playSong();
    }

    public void startGame(View view){
        startButton.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        stopSong();
        playGrr();

        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(intent);
                finish();
                startButton.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void playGrr(){
        grr.start();
    }
    public void stopGrr(){
        grr.stop();
    }
    public void playSong(){
        song.start();
        song.setLooping(true);
    }
    public void stopSong(){
        song.stop();
    }

}