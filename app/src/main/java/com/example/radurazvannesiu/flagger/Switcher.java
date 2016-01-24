package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Class that makes the transition between 2 questions.
 * It also handles the transition from the last question to the End Menu.
 *
 * @author Razvan Nesiu
 */
public class Switcher extends AppCompatActivity {

    public static int QUESTIONS_PER_MATCH = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);

        //if the current questionNumber reached the # of QUESTIONS_PER_MATCH, go to End Menu
        if (QuizActivity.getQuestionNumber() == QUESTIONS_PER_MATCH) {
            Intent intent = new Intent(Switcher.this, End.class);
            startActivity(intent);
        }
        //otherwise, go back to QuizActivity class, and display another question
        else {
            Intent intent = new Intent(Switcher.this, QuizActivity.class);
            startActivity(intent);
        }
    }
}
