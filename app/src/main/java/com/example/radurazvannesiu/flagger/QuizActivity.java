package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Class that handles the display of the questions
 *
 * @author Razvan Nesiu.
 */
public class QuizActivity extends AppCompatActivity {

    private static int player1Score = 0;
    private static int player2Score = 0;
    public static final int SECONDS_PER_QUESTION = 10;
    public static final int MILLIS_IN_A_SECOND = 1000;
    public static final QuestionDatabase QDB = QuestionDatabase.getInstance();
    //array list that stores the options available for each question
    private ArrayList<Integer> flags;
    //the current number of the question displayed in a match (Q1, Q2, Q3, etc.)
    private static int questionNumber = 0;
    //the ID of a question from the database (eg: Q1 has ID = 75 in the database)
    private static int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //the TextView objects for the currently displayed question & scores
        TextView question = (TextView) findViewById(R.id.question);
        TextView scoreP1 = (TextView) findViewById(R.id.player1Score);
        TextView scoreP2 = (TextView) findViewById(R.id.player2Score);

        /*The ImageButton objects for all the buttons that represent
        the options available for each question.
        Naming convention: b1p1 is button 1 for player 1.
        (buttons are displayed from left to right, from 1 to 8)*/
        ImageButton b1p1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton b2p1 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton b3p1 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton b4p1 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton b1p2 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton b2p2 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton b3p2 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton b4p2 = (ImageButton) findViewById(R.id.imageButton8);

        /* The following Strings represent the names of the flags displayed
        (eg: flagNameForBtn1 = "france" is used to display France's flag
        on button 1 from both player 1 & player 2)*/
        String flagNameForBtn1;
        String flagNameForBtn2;
        String flagNameForBtn3;
        String flagNameForBtn4;
        // declaring the resources for the above mentioned buttons
        int resB1;
        int resB2;
        int resB3;
        int resB4;

        //get a random question ID from the database and store it in questionId
        questionId = QDB.getRandomQuestionId();
        //get the array list of the flags that will be displayed for this question
        flags = QDB.getFlagIndexesArrayList(questionId);

        /* Since we have the IDs of the flags,
        we get from the database the names of the png files corresponding to those indexes.*/
        flagNameForBtn1 = QuestionDatabase.FLAGS[flags.get(0)];
        flagNameForBtn2 = QuestionDatabase.FLAGS[flags.get(1)];
        flagNameForBtn3 = QuestionDatabase.FLAGS[flags.get(2)];
        flagNameForBtn4 = QuestionDatabase.FLAGS[flags.get(3)];

        //set the values for the resources
        resB1 = getResources().getIdentifier(flagNameForBtn1, "drawable", getPackageName());
        resB2 = getResources().getIdentifier(flagNameForBtn2, "drawable", getPackageName());
        resB3 = getResources().getIdentifier(flagNameForBtn3, "drawable", getPackageName());
        resB4 = getResources().getIdentifier(flagNameForBtn4, "drawable", getPackageName());

        //draw the images of the flags on the buttons
        b1p1.setImageResource(resB1);
        b1p2.setImageResource(resB1);

        b2p1.setImageResource(resB2);
        b2p2.setImageResource(resB2);

        b3p1.setImageResource(resB3);
        b3p2.setImageResource(resB3);

        b4p1.setImageResource(resB4);
        b4p2.setImageResource(resB4);

        /* Increment the question number. (At the beginning of a match questionNumber is 0,
        but it gets incremented by 1, and then the first question is displayed)*/
        questionNumber++;

        //display the question
        question.setText(questionNumber + ". " + QuestionDatabase.QUESTIONS[questionId]);

        //display the score
        scoreP1.setText(player1Score + "");
        scoreP2.setText(player2Score + "");

        //initialize the TextView that displays the time left for a question to be answered
        final TextView TIMER = (TextView) findViewById(R.id.timer);
        //set the CountDownTimer (both parameters are in milliseconds)
        final CountDownTimer START = new CountDownTimer(SECONDS_PER_QUESTION * MILLIS_IN_A_SECOND,
                MILLIS_IN_A_SECOND) {

            public void onTick(long millisUntilFinished) {
                //display the # of seconds left
                TIMER.setText(millisUntilFinished / MILLIS_IN_A_SECOND + "");
            }

            public void onFinish() {
                TIMER.setText(R.string.textTimeIsUp);
                //question finished, go to Switcher class
                Intent intent = new Intent(QuizActivity.this, Switcher.class);
                startActivity(intent);
            }
        }.start();
    }

    //getter for the current number of the question displayed (questionNumber)
    public static int getQuestionNumber() {
        return questionNumber;
    }

    //setter for questionNumber
    public static void setQuestionNumber(int newQuestionNumber) {
        questionNumber = newQuestionNumber;
    }

    //setter for Player 1's score
    public static void setPlayer1Score(int newScore) {
        player1Score = newScore;
    }

    //getter for Player 1's score
    public static int getPlayer1Score() {
        return player1Score;
    }

    //setter for Player 2's score
    public static void setPlayer2Score(int newScore) {
        player2Score = newScore;
    }

    //getter for Player 2's score
    public static int getPlayer2Score() {
        return player2Score;
    }

    //handler for button 1 from Player 1
    public void player1Button1OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(0) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player1Score++;
        }

    }

    //handler for button 2 from Player 1
    public void player1Button2OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(1) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player1Score++;
        }
    }

    //handler for button 3 from Player 1
    public void player1Button3OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(2) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player1Score++;
        }
    }

    //handler for button 4 from Player 1
    public void player1Button4OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(3) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player1Score++;
        }
    }

    //handler for button 1 from Player 2
    public void player2Button1OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(0) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player2Score++;
        }
    }

    //handler for button 2 from Player 2
    public void player2Button2OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(1) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player2Score++;
        }
    }

    //handler for button 3 from Player 2
    public void player2Button3OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(2) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player2Score++;
        }
    }

    //handler for button 4 from Player 2
    public void player2Button4OnClickHandler(View view) {
        //if flag ID matches the correct flag for the current question, increment score
        if (flags.get(3) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
            player2Score++;
        }
    }
}
