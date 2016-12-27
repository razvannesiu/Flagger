package com.example.radurazvannesiu.flagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {

    private SeekBar singlePlayerQuestionsBar;
    private SeekBar multiPlayerQuestionsBar;
    private SeekBar singlePlayerSecondsBar;
    private SeekBar multiPlayerSecondsBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        singlePlayerQuestionsBar = (SeekBar) findViewById(R.id.sbNrQuestionsSingle);
        singlePlayerSecondsBar = (SeekBar) findViewById(R.id.sbNrSecondsSingle);
        multiPlayerQuestionsBar = (SeekBar) findViewById(R.id.sbNrQuestionsMulti);
        multiPlayerSecondsBar = (SeekBar) findViewById(R.id.sbNrSecondsMulti);

        singlePlayerQuestionsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SinglePlayerQuiz.QUESTIONS_PER_MATCH = progress;
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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
