package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Switcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);
        if(QuizActivity.questionNumber == 6){
            Intent intent = new Intent(Switcher.this, End.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(Switcher.this, QuizActivity.class);
            startActivity(intent);
        }
    }
}
