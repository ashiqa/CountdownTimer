package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar timeSlider ;
    TextView timerTextView ;
    public void updateTimer(int totalTime){
        int minutes=(int) totalTime/ 60 ;
        int seconds= totalTime-minutes*60;
        String mins=Integer.toString(minutes) ;
        String secs=Integer.toString(seconds);
        if(minutes<=9){
            mins="0"+mins;
        }
        if(seconds<=9){
            secs="0"+secs ;
        }
        timerTextView.setText(mins+":"+secs);
    }
    public void startCountDown(View view){
        new CountDownTimer(timeSlider.getProgress()*1000+100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                timerTextView.setText("00:00");
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeSlider = (SeekBar) findViewById(R.id.timerSeekBar);
         timerTextView = (TextView) findViewById(R.id.timerTextView);
        timeSlider.setMax(600); //600sec=>10min
        timeSlider.setProgress(30);
        timeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               updateTimer(progress);
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