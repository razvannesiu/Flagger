package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Class that displays the End Menu and handles its events.
 * It also shows who's the winner (or draw).
 *
 * @author Razvan Nesiu
 */
public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView winnerTextView = (TextView) findViewById(R.id.textWinner);
        String winnerStatus = "";

        //in case of equality
        if (QuizActivity.getPlayer1Score() == QuizActivity.getPlayer2Score()) {
            winnerStatus = "Draw!";
        }
        //if Player 1 wins
        else if (QuizActivity.getPlayer1Score() > QuizActivity.getPlayer2Score()) {
            winnerStatus = "Player1 won!";
        }
        //if Player 2 wins
        else {
            winnerStatus = "Player2 won!";
        }
        //display winnerStatus
        winnerTextView.setText(winnerStatus);
    }

    /**
     * Method that handles the Rematch button from the End Menu.
     *
     * @param view3 View for this handler.
     */
    public void rematchHandler(View view3) {
        QuizActivity.setQuestionNumber(0);
        QuizActivity.setPlayer1Score(0);
        QuizActivity.setPlayer2Score(0);
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
        generator.resetQuestionIdGenerator();
        Intent intent = new Intent(End.this, QuizActivity.class);
        startActivity(intent);
    }

    /**
     * Method that handles the Quit button from the End Menu.
     *
     * @param view4 View for this handler.
     */
    public void quitHandler(View view4) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
