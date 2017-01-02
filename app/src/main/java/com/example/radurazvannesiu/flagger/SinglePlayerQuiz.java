package com.example.radurazvannesiu.flagger;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

@SuppressWarnings("ALL")
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
    private final RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
    //initialize the TextView that displays the time left for a question to be answered
    public TextView txt_timer;
    //seekBar that displays score
    SeekBar scoreBar;
    //dialog box that displays the correct flag
    Dialog dialog;
    //array list that stores the options available for each question
    private ArrayList<Integer> flags;
    //the TextViews
    private TextView question;
    //the ImageButtons
    private ImageButton sib0;
    private ImageButton sib1;
    private ImageButton sib2;
    private ImageButton sib3;
    private Resources res;
    private String packageName;
    //set the CountDownTimer (both parameters are in milliseconds)
    private CountDownTimer timer;
    private AlphaAnimation alphaAnimation;
    //check if players did answer the current question
    private boolean didPlayerAnswerCorrectly;

    //getter for the current number of the question displayed (questionNumber)
    public static int getQuestionNumber() {
        return questionNumber;
    }

    //getter for the score
    public static int getScore() {
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_quiz);

        //load the new preferences from the settings file
        Settings.loadPreferencesFromFile(this);

        //load resources
        res = getResources();

        //initialize animation (goes to 25% transparency)
        alphaAnimation = new AlphaAnimation(1, 0.25f);
        alphaAnimation.setDuration(MultiPlayerQuiz.BTN_ANIMATION_DURATION_IN_MILLIS);

        //set question number & score at beginning
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

        scoreBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //user cannot change the progress of the bar (by clicking the SeekBar)
                if(fromUser){
                    seekBar.setProgress(score);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //ignore
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //ignore
            }
        });

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

                //increment the score, if player answered correctly
                if(didPlayerAnswerCorrectly) {
                    score += 1;
                }
                scoreBar.setProgress(score);

                //reset color to normal
                txt_timer.setTextColor(Color.BLACK);

                //increment question number
                questionNumber += 1;

                showAnswerBox(questionId);
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

        //set answer as wrong (initially)
        didPlayerAnswerCorrectly = false;

        /* Since we have the IDs of the flags,
        we get from the database the names of the png files corresponding to those indexes.*/
        String flagNameForBtn1 = QuestionDatabase.FLAGS[flags.get(0)];
        String flagNameForBtn2 = QuestionDatabase.FLAGS[flags.get(1)];
        String flagNameForBtn3 = QuestionDatabase.FLAGS[flags.get(2)];
        String flagNameForBtn4 = QuestionDatabase.FLAGS[flags.get(3)];

        //set the values for the resources
        int resB1 = res.getIdentifier(flagNameForBtn1, "drawable", packageName);
        int resB2 = res.getIdentifier(flagNameForBtn2, "drawable", packageName);
        int resB3 = res.getIdentifier(flagNameForBtn3, "drawable", packageName);
        int resB4 = res.getIdentifier(flagNameForBtn4, "drawable", packageName);

        //draw the images of the flags on the buttons
        sib0.setImageResource(resB1);
        sib1.setImageResource(resB2);
        sib2.setImageResource(resB3);
        sib3.setImageResource(resB4);

        //display the question
        question.setText(String.format(Locale.getDefault(), "%d. %s", questionNumber, QuestionDatabase.QUESTIONS[questionId]));

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

        //set validity of answer
        didPlayerAnswerCorrectly = (flags.get(tag) == QuestionDatabase.QUESTION_ANSWER_MAP[questionId]);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    /**
     * Show dialog box with correct answer.
     * @param questionId The ID of the current question.
     */
    private void showAnswerBox(int questionId) {
        dialog = new Dialog(this, R.style.DialogWithTitleCentered);
        dialog.setContentView(R.layout.single_player_answer_box);
        int flagId = QuestionDatabase.QUESTION_ANSWER_MAP[questionId];
        ImageButton ibCorrectFlag = (ImageButton) dialog.findViewById(R.id.ibCorrectFlag);
        String nameOfCorrectFlag = QuestionDatabase.FLAGS[flagId];
        int flagImageResource = res.getIdentifier(nameOfCorrectFlag, "drawable", packageName);
        ibCorrectFlag.setImageResource(flagImageResource);

        Button btnNextQuestion = (Button) dialog.findViewById(R.id.btnNextQuestion);
        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();

                //if the current questionNumber reached the # of QUESTIONS_PER_MATCH, go to End Menu
                if (SinglePlayerQuiz.getQuestionNumber() > SinglePlayerQuiz.QUESTIONS_PER_MATCH) {
                    Intent intent = new Intent(SinglePlayerQuiz.this, End.class);
                    startActivity(intent);
                    finish();
                }
                //otherwise load next question
                else {
                    loadQuestion();
                }
            }
        });

        int idOfTextOnButton = didPlayerAnswerCorrectly? R.string.dialogButtonCorrect : R.string.dialogButtonWrong;
        btnNextQuestion.setText(res.getText(idOfTextOnButton));

        //set color and text for the country with correct flag
        TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
        int idOfColor = didPlayerAnswerCorrectly? R.color.colorCorrect : R.color.colorWrong;
        tvTitle.setTextColor(res.getColor(idOfColor));
        tvTitle.setText(getFormattedFlagName(nameOfCorrectFlag));

        dialog.setTitle(R.string.dialogTitle);
        dialog.show();
    }

    /**
     * Formats a flag name so that it can be displayed to the user.
     * @param flagName The flag name, which contains underscores, and it's all in lowercase.
     * @return The nicely formatted name of the flag.
     */
    private String getFormattedFlagName(String flagName){
        String nameToDisplay = "";
        String[] names = flagName.split("_");
        for(String name: names){
            nameToDisplay += name.toUpperCase().charAt(0) + name.substring(1) + " ";
        }

        return nameToDisplay;
    }

}
