package com.example.peraltar.whackamole;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class Level2Activity extends AppCompatActivity {

    Timer timer;
    TimerTask timerTask;
    private CountDownTimer countDownTimer;
    private TextView time;
    private TextView tvScore;
    private int score;
    private int randomTime;
    private int randomMole;

    private ImageView mole1;
    private ImageView mole2;
    private ImageView mole3;
    private ImageView mole4;
    private ImageView mole5;
    private ImageView mole6;
    private ImageView mole7;
    private ImageView mole8;
    private ImageView mole9;
    private ImageView mole10;
    private ImageView mole11;
    private ImageView mole12;

    ImageView[] moleArray = new ImageView[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);

        mole1 = (ImageView) findViewById(R.id.mole1);
        mole2 = (ImageView) findViewById(R.id.mole2);
        mole3 = (ImageView) findViewById(R.id.mole3);
        mole4 = (ImageView) findViewById(R.id.mole4);
        mole5 = (ImageView) findViewById(R.id.mole5);
        mole6 = (ImageView) findViewById(R.id.mole6);
        mole7 = (ImageView) findViewById(R.id.mole7);
        mole8 = (ImageView) findViewById(R.id.mole8);
        mole9 = (ImageView) findViewById(R.id.mole9);
        mole10 = (ImageView) findViewById(R.id.mole10);
        mole11 = (ImageView) findViewById(R.id.mole11);
        mole12 = (ImageView) findViewById(R.id.mole12);
        tvScore = (TextView) findViewById(R.id.score);
        time = (TextView) findViewById(R.id.timer);

        moleArray[0] = mole1;
        moleArray[1] = mole2;
        moleArray[2] = mole3;
        moleArray[3] = mole4;
        moleArray[4] = mole5;
        moleArray[5] = mole6;
        moleArray[6] = mole7;
        moleArray[7] = mole8;
        moleArray[8] = mole9;
        moleArray[9] = mole10;
        moleArray[10] = mole11;
        moleArray[11] = mole12;
        score = 0;

        startTimer();
    }

    public void startTimer() {
        randomTime = (int)(Math.random() * 3000 + 2000);
        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(final long timeLeft) {
                time.setText("" + timeLeft / 1000);
                final Handler handler = new Handler();
                final Runnable r = new Runnable() {
                    public void run() {
                        getRandomMole();
                    }
                };
                handler.postDelayed(r, randomTime);
                makeInvisible();
            }
            public void onFinish() {
                time.setText("");
                clearMoles();
                resultsScreen();
            }
        }.start();
    }


    public void getRandomMole(){
        randomMole = (int)(Math.random() * 12 + 0);
        moleArray[randomMole].setVisibility(View.VISIBLE);

        moleArray[randomMole].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                tvScore.setText("" + score);
                moleArray[randomMole].setVisibility(View.INVISIBLE);
            }
        });
    }

    public void makeInvisible() {
        moleArray[randomMole].setVisibility(View.INVISIBLE);
    }

    public void clearMoles() {
        moleArray[0].setVisibility(View.INVISIBLE);
        moleArray[1].setVisibility(View.INVISIBLE);
        moleArray[2].setVisibility(View.INVISIBLE);
        moleArray[3].setVisibility(View.INVISIBLE);
        moleArray[4].setVisibility(View.INVISIBLE);
        moleArray[5].setVisibility(View.INVISIBLE);
        moleArray[6].setVisibility(View.INVISIBLE);
        moleArray[7].setVisibility(View.INVISIBLE);
        moleArray[8].setVisibility(View.INVISIBLE);
        moleArray[9].setVisibility(View.INVISIBLE);
        moleArray[10].setVisibility(View.INVISIBLE);
        moleArray[11].setVisibility(View.INVISIBLE);
    }

    public void resultsScreen(){
        String s = "" + score;
        Intent intent = new Intent(this, ResultsActivity2.class);
        intent.putExtra("score", s);
        startActivity(intent);
    }

}