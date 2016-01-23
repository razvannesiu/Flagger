package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    public static int player1Score = 0;
    public static int player2Score = 0;
    public static QuestionDatabase qdb = QuestionDatabase.getInstance();
    private ArrayList<Integer> flags;
    public static int questionID;
    public static int questionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView question = (TextView) findViewById(R.id.question);

        ImageButton b1p1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton b2p1 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton b3p1 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton b4p1 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton b1p2 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton b2p2 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton b3p2 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton b4p2 = (ImageButton) findViewById(R.id.imageButton8);

        final TextView scoreP1 = (TextView) findViewById(R.id.player1Score);
        final TextView scoreP2 = (TextView) findViewById(R.id.player2Score);

        String btn1;
        String btn2;
        String btn3;
        String btn4;
        int resB1;
        int resB2;
        int resB3;
        int resB4;

        questionID = qdb.getRandomQuestion();
        flags = qdb.getFlags(questionID);


        btn1 = QuestionDatabase.FLAGS[flags.get(0)];
        btn2 = QuestionDatabase.FLAGS[flags.get(1)];
        btn3 = QuestionDatabase.FLAGS[flags.get(2)];
        btn4 = QuestionDatabase.FLAGS[flags.get(3)];

        resB1 = getResources().getIdentifier(btn1, "drawable", getPackageName());
        resB2 = getResources().getIdentifier(btn2, "drawable", getPackageName());
        resB3 = getResources().getIdentifier(btn3, "drawable", getPackageName());
        resB4 = getResources().getIdentifier(btn4, "drawable", getPackageName());

        b1p1.setImageResource(resB1);
        b1p2.setImageResource(resB1);

        b2p1.setImageResource(resB2);
        b2p2.setImageResource(resB2);

        b3p1.setImageResource(resB3);
        b3p2.setImageResource(resB3);

        b4p1.setImageResource(resB4);
        b4p2.setImageResource(resB4);

        question.setText(questionNumber + ". " + QuestionDatabase.QUESTIONS[questionID]);
        questionNumber++;

        scoreP1.setText(player1Score + "");
        scoreP2.setText(player2Score + "");

        final TextView timer = (TextView) findViewById(R.id.timer);
        final CountDownTimer start = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + "");
            }

            public void onFinish() {
                timer.setText("Time is up!");
                Intent intent = new Intent(QuizActivity.this, Switcher.class);
                startActivity(intent);
            }
        }.start();
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    public void player1Button1OnClickHandler(View view) {
        if (flags.get(0) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player1Score++;
        }

    }

    public void player1Button2OnClickHandler(View view) {
        if (flags.get(1) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player1Score++;
        }
    }

    public void player1Button3OnClickHandler(View view) {
        if (flags.get(2) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player1Score++;
        }
    }

    public void player1Button4OnClickHandler(View view) {
        if (flags.get(3) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player1Score++;
        }
    }

    public void player2Button1OnClickHandler(View view) {
        if (flags.get(0) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player2Score++;
        }
    }

    public void player2Button2OnClickHandler(View view) {
        if (flags.get(1) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player2Score++;
        }
    }

    public void player2Button3OnClickHandler(View view) {
        if (flags.get(2) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player2Score++;
        }
    }

    public void player2Button4OnClickHandler(View view) {
        if (flags.get(3) == QuestionDatabase.ANSWER_MAP[questionID]) {
            player2Score++;
        }
    }
}
