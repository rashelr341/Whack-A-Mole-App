package com.example.peraltar.whackamole;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.nyan);
        mediaPlayer.start();

    }

    /** Called when the user taps the "Level 1" button */
    public void levelOne(View view) {
        Intent intent = new Intent(this, Level1Activity.class);
        startActivity(intent);
    }

    /** Called when the user taps the "Level 2" button */
    public void levelTwo(View view) {
        Intent intent = new Intent(this, Level2Activity.class);
        startActivity(intent);
    }

    /** Called when the user taps the "Level 3" button */
    public void levelThree(View view) {
        Intent intent = new Intent(this, Level3Activity.class);
        startActivity(intent);
    }

}
