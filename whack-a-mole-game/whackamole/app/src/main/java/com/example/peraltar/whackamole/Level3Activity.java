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

public class Level3Activity extends AppCompatActivity {

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
    private ImageView mole13;
    private ImageView mole14;
    private ImageView mole15;
    private ImageView mole16;
    private ImageView mole17;
    private ImageView mole18;
    private ImageView mole19;
    private ImageView mole20;

    ImageView[] moleArray = new ImageView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_3);

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
        mole13 = (ImageView) findViewById(R.id.mole12);
        mole14 = (ImageView) findViewById(R.id.mole12);
        mole15 = (ImageView) findViewById(R.id.mole12);
        mole16 = (ImageView) findViewById(R.id.mole12);
        mole17 = (ImageView) findViewById(R.id.mole12);
        mole18 = (ImageView) findViewById(R.id.mole12);
        mole19 = (ImageView) findViewById(R.id.mole12);
        mole20 = (ImageView) findViewById(R.id.mole12);
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
        moleArray[12] = mole13;
        moleArray[13] = mole14;
        moleArray[14] = mole15;
        moleArray[15] = mole16;
        moleArray[16] = mole17;
        moleArray[17] = mole18;
        moleArray[18] = mole19;
        moleArray[19] = mole20;
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
        randomMole = (int)(Math.random() * 20 + 0);
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
        moleArray[12].setVisibility(View.INVISIBLE);
        moleArray[13].setVisibility(View.INVISIBLE);
        moleArray[14].setVisibility(View.INVISIBLE);
        moleArray[15].setVisibility(View.INVISIBLE);
        moleArray[16].setVisibility(View.INVISIBLE);
        moleArray[17].setVisibility(View.INVISIBLE);
        moleArray[18].setVisibility(View.INVISIBLE);
        moleArray[19].setVisibility(View.INVISIBLE);
    }

    public void resultsScreen(){
        String s = "" + score;
        Intent intent = new Intent(this, ResultsActivity3.class);
        intent.putExtra("score", s);
        startActivity(intent);
    }

}