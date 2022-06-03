package com.example.catchtheperry;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    int score;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
    ImageView imageView23;
    ImageView imageView24;
    ImageView imageView25;
    ImageView imageView26;
    ImageView imageView27;
    ImageView[] imageArray;
    ImageView[] imageHeinzArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //initialize
        scoreText = findViewById(R.id.textView);
        timeText = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView2);
        imageView1 = findViewById(R.id.imageView3);
        imageView2 = findViewById(R.id.imageView5);
        imageView3 = findViewById(R.id.imageView6);
        imageView4 = findViewById(R.id.imageView7);
        imageView5 = findViewById(R.id.imageView8);
        imageView6 = findViewById(R.id.imageView9);
        imageView7 = findViewById(R.id.imageView10);
        imageView8 = findViewById(R.id.imageView11);
        imageView9 = findViewById(R.id.imageView12);
        imageView10 = findViewById(R.id.imageView13);
        imageView11 = findViewById(R.id.imageView14);
        imageView12 = findViewById(R.id.imageView15);
        imageView13 = findViewById(R.id.imageView16);
        imageView14 = findViewById(R.id.imageView17);
        imageView15 = findViewById(R.id.imageView18);
        imageView16 = findViewById(R.id.imageView19);
        imageView17 = findViewById(R.id.imageView20);
        imageView18 = findViewById(R.id.imageView21);
        imageView19 = findViewById(R.id.imageView22);
        imageView20 = findViewById(R.id.imageView23);
        imageView21 = findViewById(R.id.imageView24);
        imageView22 = findViewById(R.id.imageView25);
        imageView23 = findViewById(R.id.imageView26);
        imageView24 = findViewById(R.id.imageView27);
        imageView25 = findViewById(R.id.imageView28);
        imageView26 = findViewById(R.id.imageView29);
        imageView27 = findViewById(R.id.imageView30);

        imageArray = new ImageView[] {
                imageView,
                imageView1,
                imageView2,
                imageView3,
                imageView4,
                imageView5,
                imageView6,
                imageView7,
                imageView8,
                imageView9,
                imageView10,
                imageView11,
                imageView12,
                imageView13,
                imageView14,
                imageView15,
                imageView16,
                imageView17,
                imageView18,
                imageView19,
        };

        imageHeinzArray = new ImageView[]{
             imageView20,
             imageView21,
             imageView22,
             imageView23,
             imageView24,
             imageView25,
             imageView26,
             imageView27
        };

        hideImages();

        score = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l / 1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time Off!");
                handler.removeCallbacks(runnable);

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("Restart");
                alert.setMessage("Score: "+ score +"\nAre you sure restart ?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Game Over!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivityStart.class);
                        finish();
                        startActivity(intent);
                    }
                });

                alert.show();

            }
        }.start();
    }

    public void increaseScore(View view) {
        score++;
        scoreText.setText("Score: " + score);
    }

    public void reduceScore(View view){
        score--;
        scoreText.setText("Score: " + score);
    }

    public void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int sayi = 0;
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                for (ImageView imageHeinz : imageHeinzArray){
                    imageHeinz.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(28);
                if(i < 20){
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this,650);//this burada runnable kapsayıcı olduğu için runnable ı işaret ediyor
                }else{
                    sayi = i;
                    sayi = sayi - 20;
                    if(sayi >= 0 && sayi <= 7)
                    imageHeinzArray[sayi].setVisibility(View.VISIBLE);
                    handler.postDelayed(this,450);//this burada runnable kapsayıcı olduğu için runnable ı işaret ediyor
                }

            }
        };

        handler.post(runnable);

    }
}