package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        TextView winner = (TextView) findViewById(R.id.textWinner);
        String winnerStatus = "";
        if (QuizActivity.player1Score == QuizActivity.player2Score) {
            winnerStatus = "Draw!";
        } else if (QuizActivity.player1Score > QuizActivity.player2Score) {
            winnerStatus = "Player1 won!";
        } else {
            winnerStatus = "Player2 won!";
        }
        winner.setText(winnerStatus);
    }

    public void rematchHandler(View view3) {
        QuizActivity.questionNumber = 1;
        QuizActivity.player1Score = 0;
        QuizActivity.player2Score = 0;
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
        generator.resetQuestionGenerator();
        Intent intent = new Intent(End.this, QuizActivity.class);
        startActivity(intent);
    }

    public void quitHandler(View view4) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
