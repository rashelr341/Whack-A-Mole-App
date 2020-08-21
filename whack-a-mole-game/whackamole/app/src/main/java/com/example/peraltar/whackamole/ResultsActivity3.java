package com.example.peraltar.whackamole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_3);

        Intent intent = getIntent();
        String message = intent.getStringExtra("score");
        TextView textView = findViewById(R.id.finalScore);
        textView.setText(message);
    }

    public void replay (View view) {
        Intent intent = new Intent(this, Level3Activity.class);
        startActivity(intent);
    }

    public void main (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
