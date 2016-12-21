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

    //determines if a game is multiplayer or not (changes behavior of QuizActivity)
    public static boolean isMultiplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * Method that handles the Offline Multiplayer & Single Player buttons from the Start Menu.
     *
     * @param view View for this handler.
     */
    public void playBtnHandler(View view) {
        Intent intent = new Intent(Start.this, QuizActivity.class);
        startActivity(intent);

        String tag = view.getTag().toString();

        if(tag.equals("Single")){
            isMultiplayer = false;
        }
        else if(tag.equals("Multi")){
            isMultiplayer = true;
        }
    }
}
