package com.example.radurazvannesiu.flagger;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class SinglePlayerQuiz extends AppCompatActivity {

    public static final QuestionDatabase QDB = QuestionDatabase.getInstance();
    //subject to change according to settings
    public static int SECONDS_PER_QUESTION = 10;
    public static int QUESTIONS_PER_MATCH = 5;
    private static int score;
    //the current number of the question displayed in a match (Q1, Q2, Q3, etc.)
    private static int questionNumber;
    //the ID of a question from the database (eg: Q1 has ID = 75 in the database)
    private static int questionId;
    //initialize the TextView that displays the time left for a question to be answered
    public TextView txt_timer;
    //seekBar that displays score
    SeekBar scoreBar;
    //array list that stores the options available for each question
    private ArrayList<Integer> flags;
    //the TextViews
    private TextView question;
    //the ImageButtons
    private ImageButton sib0;
    private ImageButton sib1;
    private ImageButton sib2;
    private ImageButton sib3;
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
    private boolean didPlayerAnswerCorrectly;

    //getter for the current number of the question displayed (questionNumber)
    public static int getQuestionNumber() {
        return questionNumber;
    }

    //setter for questionNumber
    public static void setQuestionNumber(int newQuestionNumber) {
        questionNumber = newQuestionNumber;
    }

    //getter for the score
    public static int getScore() {
        return score;
    }

    //setter for the score
    public static void setScore(int newScore) {
        score = newScore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_quiz);

        //load resources
        res = getResources();

        //initialize animation (goes to 25% transparency)
        alphaAnimation = new AlphaAnimation(1, 0.25f);
        alphaAnimation.setDuration(MultiPlayerQuiz.BTN_ANIMATION_DURATION_IN_MILLIS);

        //set question number & scores at beginning
        questionNumber = 1;
        score = 0;

        //reset generator
        generator.resetQuestionIdGenerator();

        //set package name
        packageName = getPackageName();

        //initialize TextView that displays # of seconds left
        txt_timer = (TextView) findViewById(R.id.timer);

        //the TextView objects for the currently displayed question & scores
        question = (TextView) findViewById(R.id.question);
        scoreBar = (SeekBar) findViewById(R.id.scoreBar);
        scoreBar.setMax(SinglePlayerQuiz.QUESTIONS_PER_MATCH);
        scoreBar.setProgress(0);

        /*The ImageButton objects for all the buttons that represent
        the options available for each question.
        Naming convention: sb0 is the first button in a single player game.
        (buttons are displayed from left to right, from 0 to 3)*/
        sib0 = (ImageButton) findViewById(R.id.sib0);
        sib1 = (ImageButton) findViewById(R.id.sib1);
        sib2 = (ImageButton) findViewById(R.id.sib2);
        sib3 = (ImageButton) findViewById(R.id.sib3);

        //get screen dimensions, and set the left padding for leftmost button
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Display display = getWindowManager().getDefaultDisplay();
            Point p = new Point();
            display.getSize(p);
            //there are 4 buttons + 3 gaps in between, so in total 7 blocks
            //divide by 2 to get left padding for leftmost button
            int offsetForLeftmostButton = (p.x - res.getDimensionPixelSize(R.dimen.flagMarginSingleplayer) * 7) / 2;
            sib0.setPadding(offsetForLeftmostButton, sib0.getPaddingTop(), sib0.getPaddingRight(), sib0.getPaddingBottom());
        }

        //setup timer (we need 1 extra sec to cope with the initial delay)
        timer = new CountDownTimer((SinglePlayerQuiz.SECONDS_PER_QUESTION + 1) * MultiPlayerQuiz.MILLIS_IN_A_SECOND,
                MultiPlayerQuiz.MILLIS_IN_A_SECOND) {

            public void onTick(long millisUntilFinished) {
                /*If time is almost done, display the time in red.
                (Need to add 1 extra sec for TIMER_RED_THRESHOLD_IN_MILLIS to cope with initial delay)
                */
                if (millisUntilFinished <= MultiPlayerQuiz.TIMER_RED_THRESHOLD_IN_MILLIS + 1000) {
                    txt_timer.setTextColor(Color.RED);
                }

                //show the time
                txt_timer.setText(String.valueOf(millisUntilFinished / MultiPlayerQuiz.MILLIS_IN_A_SECOND));
            }

            public void onFinish() {

                //reset color to normal
                txt_timer.setTextColor(Color.BLACK);

                //increment question number
                questionNumber += 1;

                //if the current questionNumber reached the # of QUESTIONS_PER_MATCH, go to End Menu
                if (SinglePlayerQuiz.getQuestionNumber() > SinglePlayerQuiz.QUESTIONS_PER_MATCH) {
                    Intent intent = new Intent(SinglePlayerQuiz.this, End.class);
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
        didPlayerAnswerCorrectly = false;

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
        sib0.setImageResource(resB1);
        sib1.setImageResource(resB2);
        sib2.setImageResource(resB3);
        sib3.setImageResource(resB4);

        //display the question
        question.setText(String.format(Locale.getDefault(), "%d. %s", questionNumber, QuestionDatabase.QUESTIONS[questionId]));

        //display the score
        scoreBar.setProgress(score);

        timer.start();
    }

    /**
     * Handles flag taps for the player.
     * @param flag Flag tapped.
     */
    public void playerChoseAnswer(View flag) {
        int tag = Integer.parseInt(flag.getTag().toString());

        //animate button
        flag.startAnimation(alphaAnimation);

        //check if the player didn't answer yet
        if (!didPlayerAnswerCorrectly) {

            //check if answer is correct
            if (flags.get(tag) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]) {
                score += 1;
            }

            //mark question as 'answered'
            didPlayerAnswerCorrectly = true;
        }
    }
}
