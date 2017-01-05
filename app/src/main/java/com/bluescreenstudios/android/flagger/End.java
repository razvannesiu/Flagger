package com.bluescreenstudios.android.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Class that displays the End Menu and handles its events.
 * It also shows who's the winner (or draw).
 *
 * @author Razvan Nesiu
 */
public class End extends AppCompatActivity {

    private String endGameStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView winnerTextView = (TextView) findViewById(R.id.textWinner);
        endGameStatus = "";

        if(Start.isMultiPlayer){
            gameOverLogicMultiPlayer();
        }
        else{
            endGameStatus = String.format(Locale.getDefault(), "Your score is %.0f%%",
                    Math.ceil((100 * SinglePlayerQuiz.getScore()) / (float) SinglePlayerQuiz.QUESTIONS_PER_MATCH));
        }

        //display endGameStatus
        winnerTextView.setText(endGameStatus);
    }

    /**
     * Decides who won between the 2 players.
     */
    private void gameOverLogicMultiPlayer(){

        //in case of equality
        if (MultiPlayerQuiz.getPlayer1Score() == MultiPlayerQuiz.getPlayer2Score()) {
            endGameStatus = "Draw!";
        }
        //if Player 1 wins
        else if (MultiPlayerQuiz.getPlayer1Score() > MultiPlayerQuiz.getPlayer2Score()) {
            endGameStatus = "Player1 won!";
        }
        //if Player 2 wins
        else {
            endGameStatus = "Player2 won!";
        }
    }

    /**
     * Method that handles the Rematch button from the End Menu.
     *
     * @param rematchBtn The rematch button as a View.
     */
    public void rematchHandler(View rematchBtn) {
        Intent intent;

        if(Start.isMultiPlayer){
            intent = new Intent(End.this, MultiPlayerQuiz.class);
        }
        else{
            intent = new Intent(End.this, SinglePlayerQuiz.class);
        }
        startActivity(intent);
        finish();
    }

    /**
     * Handles the tap on the button that takes the user to the Start Menu.
     * @param backToMenuBtn The view of this button.
     */
    public void backToMenuHandler(View backToMenuBtn){
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
