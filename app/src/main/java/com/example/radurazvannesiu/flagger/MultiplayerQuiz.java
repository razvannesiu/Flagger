package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Class that handles the display of the questions
 *
 * @author Razvan Nesiu.
 */
public class MultiPlayerQuiz extends AppCompatActivity {

    public static final int MILLIS_IN_A_SECOND = 1000;
    public static final QuestionDatabase QDB = QuestionDatabase.getInstance();
    public static final int TIMER_RED_THRESHOLD_IN_MILLIS = 3000;
    //duration for button clicked animation
    public static final int BTN_ANIMATION_DURATION_IN_MILLIS = 600;
    //subject to change according to settings
    public static int SECONDS_PER_QUESTION = 10;
    public static int QUESTIONS_PER_MATCH = 5;
    private static int player1Score;
    private static int player2Score;
    //the current number of the question displayed in a match (Q1, Q2, Q3, etc.)
    private static int questionNumber;
    //the ID of a question from the database (eg: Q1 has ID = 75 in the database)
    private static int questionId;
    //initialize the TextView that displays the time left for a question to be answered
    public TextView txt_timer;
    //array list that stores the options available for each question
    private ArrayList<Integer> flags;
    //the TextViews
    private TextView question;
    private TextView scoreP1;
    private TextView scoreP2;
    //the ImageButtons
    private ImageButton b1p1;
    private ImageButton b2p1;
    private ImageButton b3p1;
    private ImageButton b4p1;
    private ImageButton b1p2;
    private ImageButton b2p2;
    private ImageButton b3p2;
    private ImageButton b4p2;
    /* The following Strings represent the names of the flags displayed
   (eg: flagNameForBtn1 = "france" is used to display France's flag
   on button 1 from both player 1 & player 2)*/
    private String flagNameForBtn1;
    private String flagNameForBtn2;
    private String flagNameForBtn3;
    private String flagNameForBtn4;
    // declaring the resources for the above mentioned buttons
    private int resB1;
    private int resB2;
    private int resB3;
    private int resB4;
    private Resources res;
    private String packageName;
    //set the CountDownTimer (both parameters are in milliseconds)
    private CountDownTimer timer;
    private RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
    private AlphaAnimation alphaAnimation;
    //check if players did answer the current question
    private boolean didPlayer1Answer;
    private boolean didPlayer2Answer;

    //getter for the current number of the question displayed (questionNumber)
    public static int getQuestionNumber() {
        return questionNumber;
    }

    //setter for questionNumber
    public static void setQuestionNumber(int newQuestionNumber) {
        questionNumber = newQuestionNumber;
    }

    //getter for Player 1's score
    public static int getPlayer1Score() {
        return player1Score;
    }

    //setter for Player 1's score
    public static void setPlayer1Score(int newScore) {
        player1Score = newScore;
    }

    //getter for Player 2's score
    public static int getPlayer2Score() {
        return player2Score;
    }

    //setter for Player 2's score
    public static void setPlayer2Score(int newScore) {
        player2Score = newScore;
    }

    //getter for the flag indexes
    public ArrayList<Integer> getFlags(){
        return flags;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_quiz);

        //initialize animation (goes to 25% transparency)
        alphaAnimation = new AlphaAnimation(1, 0.25f);
        alphaAnimation.setDuration(BTN_ANIMATION_DURATION_IN_MILLIS);

        //set question number & scores at beginning
        questionNumber = 1;
        player1Score = 0;
        player2Score = 0;

        //reset generator
        generator.resetQuestionIdGenerator();

        //set package name
        packageName = getPackageName();

        //initialize TextView that displays # of seconds left
        txt_timer = (TextView) findViewById(R.id.timer);

        //the TextView objects for the currently displayed question & scores
        question = (TextView) findViewById(R.id.question);
        scoreP1 = (TextView) findViewById(R.id.player1Score);
        scoreP2 = (TextView) findViewById(R.id.player2Score);

        /*The ImageButton objects for all the buttons that represent
        the options available for each question.
        Naming convention: b1p1 is button 1 for player 1.
        (buttons are displayed from left to right, from 1 to 8)*/
        b1p1 = (ImageButton) findViewById(R.id.ib0);
        b2p1 = (ImageButton) findViewById(R.id.ib1);
        b3p1 = (ImageButton) findViewById(R.id.ib2);
        b4p1 = (ImageButton) findViewById(R.id.ib3);
        b1p2 = (ImageButton) findViewById(R.id.ib4);
        b2p2 = (ImageButton) findViewById(R.id.ib6);
        b3p2 = (ImageButton) findViewById(R.id.ib5);
        b4p2 = (ImageButton) findViewById(R.id.ib7);

        //load resources
        res = getResources();

        //setup timer (we need 1 extra sec to cope with the initial delay)
        timer = new CountDownTimer((SECONDS_PER_QUESTION + 1) * MILLIS_IN_A_SECOND,
                MILLIS_IN_A_SECOND) {

            public void onTick(long millisUntilFinished) {
                /*If time is almost done, display the time in red.
                (Need to add 1 extra sec for TIMER_RED_THRESHOLD_IN_MILLIS to cope with initial delay)
                */
                if (millisUntilFinished <= TIMER_RED_THRESHOLD_IN_MILLIS + 1000) {
                    txt_timer.setTextColor(Color.RED);
                }

                //show the time
                txt_timer.setText(String.valueOf(millisUntilFinished / MILLIS_IN_A_SECOND));
            }

            public void onFinish() {

                //reset color to normal
                txt_timer.setTextColor(Color.BLACK);

                //increment question number
                questionNumber += 1;

                //if the current questionNumber reached the # of QUESTIONS_PER_MATCH, go to End Menu
                if (MultiPlayerQuiz.getQuestionNumber() > QUESTIONS_PER_MATCH) {
                    Intent intent = new Intent(MultiPlayerQuiz.this, End.class);
                    startActivity(intent);
                }
                //otherwise, load the next one
                else {
                    loadQuestion();
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadQuestion();
    }

    private void loadQuestion() {
        //get a random question ID from the database and store it in questionId
        questionId = QDB.getRandomQuestionId();
        //get the array list of the flags that will be displayed for this question
        flags = QDB.getFlagIndexesArrayList(questionId);

        //set answer check flag to false
        didPlayer1Answer = false;
        didPlayer2Answer = false;

        /* Since we have the IDs of the flags,
        we get from the database the names of the png files corresponding to those indexes.*/
        flagNameForBtn1 = QuestionDatabase.FLAGS[flags.get(0)];
        flagNameForBtn2 = QuestionDatabase.FLAGS[flags.get(1)];
        flagNameForBtn3 = QuestionDatabase.FLAGS[flags.get(2)];
        flagNameForBtn4 = QuestionDatabase.FLAGS[flags.get(3)];

        //set the values for the resources
        resB1 = res.getIdentifier(flagNameForBtn1, "drawable", packageName);
        resB2 = res.getIdentifier(flagNameForBtn2, "drawable", packageName);
        resB3 = res.getIdentifier(flagNameForBtn3, "drawable", packageName);
        resB4 = res.getIdentifier(flagNameForBtn4, "drawable", packageName);

        //draw the images of the flags on the buttons
        b1p1.setImageResource(resB1);
        b1p2.setImageResource(resB1);

        b2p1.setImageResource(resB2);
        b2p2.setImageResource(resB2);

        b3p1.setImageResource(resB3);
        b3p2.setImageResource(resB3);

        b4p1.setImageResource(resB4);
        b4p2.setImageResource(resB4);

        //display the question
        question.setText(String.format(Locale.getDefault(), "%d. %s", questionNumber, QuestionDatabase.QUESTIONS[questionId]));

        //display the score
        scoreP1.setText(String.valueOf(player1Score));
        scoreP2.setText(String.valueOf(player2Score));

        timer.start();
    }

    /**
     * Handles flag taps for player 1.
     * @param flag Flag tapped.
     */
    public void player1ChoseAnswer(View flag) {
        int tag = Integer.parseInt(flag.getTag().toString());

        //check if player 1 didn't answer yet
        if (!didPlayer1Answer) {

            //animate button
            flag.startAnimation(alphaAnimation);

            //check if answer is correct
            if (flags.get(tag) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
                player1Score += 1;
            }

            //mark question as 'answered' for player 1
            didPlayer1Answer = true;
        }
    }

    /**
     * Handles flag taps for player 2.
     * @param flag Flag tapped.
     */
    public void player2ChoseAnswer(View flag) {
        int tag = Integer.parseInt(flag.getTag().toString());

        //check if player 2 didn't answer yet
        if (!didPlayer2Answer) {

            //animate button
            flag.startAnimation(alphaAnimation);

            //check if answer is correct
            if (flags.get(tag) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
                player2Score += 1;
            }

            //mark question as 'answered' for player 2
            didPlayer2Answer = true;
        }
    }
}
