package com.example.radurazvannesiu.flagger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Settings extends AppCompatActivity {

    public static final String FILE_NAME = "Settings.txt";
    private SeekBar singlePlayerQuestionsBar;
    private SeekBar multiPlayerQuestionsBar;
    private SeekBar singlePlayerSecondsBar;
    private SeekBar multiPlayerSecondsBar;
    private TextView tvSinglePlayerNrQuestions;
    private TextView tvSinglePlayerNrSeconds;
    private TextView tvMultiPlayerNrQuestions;
    private TextView tvMultiPlayerNrSeconds;
    private int MIN_SECONDS = 3;
    private int MIN_QUESTIONS = 3;
    private File settingsFile;

    /**
     * Gets the preferences that are currently stored in the settings file.
     */
    public static void loadPreferencesFromFile(Context ctx){
        FileInputStream fileInputStream;

        try {
            fileInputStream = ctx.openFileInput(FILE_NAME);
            int character;
            String preferences = "";

            while((character = fileInputStream.read()) != -1){
                preferences += (char) character;
            }

            /* By convention, first number is number questions/ single player game,
             * second number is number seconds / single player question,
             * third number is number questions / multi player game,
             * fourth number is number seconds / multi player question.
             */
            String[] numbers = preferences.split(" ");

            SinglePlayerQuiz.QUESTIONS_PER_MATCH = Integer.parseInt(numbers[0]);
            SinglePlayerQuiz.SECONDS_PER_QUESTION = Integer.parseInt(numbers[1]);
            MultiPlayerQuiz.QUESTIONS_PER_MATCH = Integer.parseInt(numbers[2]);
            MultiPlayerQuiz.SECONDS_PER_QUESTION = Integer.parseInt(numbers[3]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //get file
        settingsFile = new File(getFilesDir(), FILE_NAME);

        //find seekBar's from XML
        singlePlayerQuestionsBar = (SeekBar) findViewById(R.id.sbNrQuestionsSingle);
        singlePlayerSecondsBar = (SeekBar) findViewById(R.id.sbNrSecondsSingle);
        multiPlayerQuestionsBar = (SeekBar) findViewById(R.id.sbNrQuestionsMulti);
        multiPlayerSecondsBar = (SeekBar) findViewById(R.id.sbNrSecondsMulti);

        //find textView's from XML
        tvSinglePlayerNrQuestions = (TextView) findViewById(R.id.tvNumberSingleQuestions);
        tvSinglePlayerNrSeconds = (TextView) findViewById(R.id.tvNumberSingleSeconds);
        tvMultiPlayerNrQuestions = (TextView) findViewById(R.id.tvNumberMultiQuestions);
        tvMultiPlayerNrSeconds = (TextView) findViewById(R.id.tvNumberMultiSeconds);

        //update SeekBar's and TextView's
        updatePreferencesOnScreen();

        singlePlayerQuestionsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= MIN_QUESTIONS) {
                    SinglePlayerQuiz.QUESTIONS_PER_MATCH = progress;
                    tvSinglePlayerNrQuestions.setText(String.valueOf(SinglePlayerQuiz.QUESTIONS_PER_MATCH));
                    writeNewPreferencesToFile();
                }
                else{
                    seekBar.setProgress(MIN_QUESTIONS);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        singlePlayerSecondsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= MIN_SECONDS) {
                    SinglePlayerQuiz.SECONDS_PER_QUESTION = progress;
                    tvSinglePlayerNrSeconds.setText(String.valueOf(SinglePlayerQuiz.SECONDS_PER_QUESTION));
                    writeNewPreferencesToFile();
                }
                else{
                    seekBar.setProgress(MIN_SECONDS);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        multiPlayerQuestionsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= MIN_QUESTIONS) {
                    MultiPlayerQuiz.QUESTIONS_PER_MATCH = progress;
                    tvMultiPlayerNrQuestions.setText(String.valueOf(MultiPlayerQuiz.QUESTIONS_PER_MATCH));
                    writeNewPreferencesToFile();
                }
                else{
                    seekBar.setProgress(MIN_QUESTIONS);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        multiPlayerSecondsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress >= MIN_SECONDS) {
                    MultiPlayerQuiz.SECONDS_PER_QUESTION = progress;
                    tvMultiPlayerNrSeconds.setText(String.valueOf(MultiPlayerQuiz.SECONDS_PER_QUESTION));
                    writeNewPreferencesToFile();
                }
                else{
                    seekBar.setProgress(MIN_SECONDS);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * Write the new values of {@code SinglePlayerQuiz.QUESTIONS_PER_MATCH},
     * {@code SinglePlayerQuiz.SECONDS_PER_QUESTION}, {@code MultiPlayerQuiz.QUESTIONS_PER_MATCH},
     * {@code MultiPlayerQuiz.SECONDS_PER_QUESTION} to the settings file.
     * @see SinglePlayerQuiz
     * @see MultiPlayerQuiz
     */
    private void writeNewPreferencesToFile(){
        String preferences = SinglePlayerQuiz.QUESTIONS_PER_MATCH + " " +
                SinglePlayerQuiz.SECONDS_PER_QUESTION + " " +
                MultiPlayerQuiz.QUESTIONS_PER_MATCH + " " +
                MultiPlayerQuiz.SECONDS_PER_QUESTION;

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(preferences.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update values of SeekBar's and TextView's to new values of {@code SinglePlayerQuiz.QUESTIONS_PER_MATCH},
     * {@code SinglePlayerQuiz.SECONDS_PER_QUESTION}, {@code MultiPlayerQuiz.QUESTIONS_PER_MATCH},
     * {@code MultiPlayerQuiz.SECONDS_PER_QUESTION}.
     * @see SinglePlayerQuiz
     * @see MultiPlayerQuiz
     */
    private void updatePreferencesOnScreen(){
        //set seekBar's to new values
        singlePlayerQuestionsBar.setProgress(SinglePlayerQuiz.QUESTIONS_PER_MATCH);
        singlePlayerSecondsBar.setProgress(SinglePlayerQuiz.SECONDS_PER_QUESTION);
        multiPlayerQuestionsBar.setProgress(MultiPlayerQuiz.QUESTIONS_PER_MATCH);
        multiPlayerSecondsBar.setProgress(MultiPlayerQuiz.SECONDS_PER_QUESTION);

        //set the number display textView's to new values
        tvSinglePlayerNrQuestions.setText(String.valueOf(SinglePlayerQuiz.QUESTIONS_PER_MATCH));
        tvSinglePlayerNrSeconds.setText(String.valueOf(SinglePlayerQuiz.SECONDS_PER_QUESTION));
        tvMultiPlayerNrQuestions.setText(String.valueOf(MultiPlayerQuiz.QUESTIONS_PER_MATCH));
        tvMultiPlayerNrSeconds.setText(String.valueOf(MultiPlayerQuiz.SECONDS_PER_QUESTION));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
