package com.example.radurazvannesiu.flagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private SeekBar singlePlayerQuestionsBar;
    private SeekBar multiPlayerQuestionsBar;
    private SeekBar singlePlayerSecondsBar;
    private SeekBar multiPlayerSecondsBar;
    private TextView tvSinglePlayerNrQuestions;
    private TextView tvSinglePlayerNrSeconds;
    private TextView tvMultiPlayerNrQuestions;
    private TextView tvMultiPlayerNrSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

        //set seekBar's to previous values
        singlePlayerQuestionsBar.setProgress(SinglePlayerQuiz.QUESTIONS_PER_MATCH);
        singlePlayerSecondsBar.setProgress(SinglePlayerQuiz.SECONDS_PER_QUESTION);
        multiPlayerQuestionsBar.setProgress(MultiPlayerQuiz.QUESTIONS_PER_MATCH);
        multiPlayerSecondsBar.setProgress(MultiPlayerQuiz.SECONDS_PER_QUESTION);

        //set the number display textView's to previous values
        tvSinglePlayerNrQuestions.setText(String.valueOf(SinglePlayerQuiz.QUESTIONS_PER_MATCH));
        tvSinglePlayerNrSeconds.setText(String.valueOf(SinglePlayerQuiz.SECONDS_PER_QUESTION));
        tvMultiPlayerNrQuestions.setText(String.valueOf(MultiPlayerQuiz.QUESTIONS_PER_MATCH));
        tvMultiPlayerNrSeconds.setText(String.valueOf(MultiPlayerQuiz.SECONDS_PER_QUESTION));

        singlePlayerQuestionsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SinglePlayerQuiz.QUESTIONS_PER_MATCH = progress;
                tvSinglePlayerNrQuestions.setText(String.valueOf(SinglePlayerQuiz.QUESTIONS_PER_MATCH));
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
                SinglePlayerQuiz.SECONDS_PER_QUESTION = progress;
                tvSinglePlayerNrSeconds.setText(String.valueOf(SinglePlayerQuiz.SECONDS_PER_QUESTION));
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
                MultiPlayerQuiz.QUESTIONS_PER_MATCH = progress;
                tvMultiPlayerNrQuestions.setText(String.valueOf(MultiPlayerQuiz.QUESTIONS_PER_MATCH));
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
                MultiPlayerQuiz.SECONDS_PER_QUESTION = progress;
                tvMultiPlayerNrSeconds.setText(String.valueOf(MultiPlayerQuiz.SECONDS_PER_QUESTION));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
      finish();
    }
}
