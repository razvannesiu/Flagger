package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Main activity & launcher class that displays the Start Menu & handles its events.
 *
 * @author Razvan Nesiu
 */
public class Start extends AppCompatActivity {

    //determines if a game is multiPlayer or not (changes behavior of MultiPlayerQuiz)
    public static boolean isMultiPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //apply new font for title
        Typeface oleoScript = Typeface.createFromAsset(getAssets(), "/Fonts/OleoScript-Bold.ttf");
        TextView tvTitle = (TextView) findViewById(R.id.txtFlagger);
        tvTitle.setTypeface(oleoScript);
    }

    /**
     * Method that handles the Offline MultiPlayer & Single Player buttons from the Start Menu.
     *
     * @param view View for this handler.
     */
    public void startMenuBtnHandler(View view) {
        Intent intent = null;

        String tag = view.getTag().toString();

        switch (tag) {
            case "Single":
                isMultiPlayer = false;
                intent = new Intent(Start.this, SinglePlayerQuiz.class);
                break;
            case "Multi":
                isMultiPlayer = true;
                intent = new Intent(Start.this, MultiPlayerQuiz.class);
                break;
            case "Settings":
                intent = new Intent(Start.this, Settings.class);
                break;
        }

        startActivity(intent);
    }
}
