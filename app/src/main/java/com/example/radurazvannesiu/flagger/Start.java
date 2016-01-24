package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Main activity & launcher class that displays the Start Menu & handles its events.
 *
 * @author Razvan Nesiu
 */
public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * Method that handles the Quit button from the Start Menu.
     *
     * @param view1 View for this handler.
     */
    public void quitHandler(View view1) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    /**
     * Method that handles the Play button from the Start Menu.
     *
     * @param view2 View for this handler.
     */
    public void playHandler(View view2) {
        Intent intent = new Intent(Start.this, QuizActivity.class);
        startActivity(intent);
    }
}
