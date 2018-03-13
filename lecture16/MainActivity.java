package com.example.installer.forresultsapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: Espen Nilsen
 *
 * Code from Lecture 16 exercises. Combines both exercises in one app.
 * (Saving instance state AND starting an activity for result)
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";//TAG for logging

    //Request code when starting PickAndChooseActivity for result
    static final int CHOOSE_COLOR_REQUEST = 1;

    //members to keep track of chosen background color
    private int mBackgroundColor = 0;
    private static final String BACKGROUND_COLOR_KEY = "backgroundColorKey";

    //members to keep track of points/score
    private int scoreCounter = 0;
    private static final String SCORE_COUNTER_KEY = "scoreCounterKey";

    //View members
    private ViewGroup layout;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get handles to view objects
        layout =  findViewById(R.id.myLayout);
        counterTextView =  findViewById(R.id.textView);

        //If the bundle exist restore any saved state
        if (savedInstanceState != null){
            scoreCounter = savedInstanceState.getInt(SCORE_COUNTER_KEY);
            mBackgroundColor = savedInstanceState.getInt(BACKGROUND_COLOR_KEY);
        }

        //Update views according to current state
        counterTextView.setText(Integer.toString(scoreCounter));
        layout.setBackgroundColor(mBackgroundColor);
    }

    /*
    ON CLICK METHODS
     */

    //"Set Backgound Color" button clicked
    // Start PickAndChooseActivity for the user to choose a background color
    public void startPickAndChooseActivity(View view){
        Intent intent = new Intent(this, PickAndChooseActivity.class);
        startActivityForResult(intent,CHOOSE_COLOR_REQUEST);
    }

    //"Get Points" button clicked
    //Increment scoreCounter and update textView
    public void getPoints(View view){
        scoreCounter++;
        counterTextView.setText(Integer.toString(scoreCounter));
    }

    /*
    RECEIVE RESULT (from calls to startActivityForResult())
     */
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("MainActivity", "We received some result");
        //Check which request we are receiving results from
        //(strictly not necessary since CHOOSE_COLOR_REQUEST is the only sent by this Activity
        if (requestCode == CHOOSE_COLOR_REQUEST){
            Log.i("MainActivity", "Choose_Color_Request");
            //If the result is not set properly the system returns Activity.CANCELED
            if(resultCode == Activity.RESULT_OK){
                Log.i("MainActivity", "Result OK");
                mBackgroundColor = data.getIntExtra(PickAndChooseActivity.
                        EXTRA_COLOR_CHOICE,mBackgroundColor);
                layout.setBackgroundColor(mBackgroundColor);

            }
        }
    }

    /*
    SAVE INSTANCE STATE
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_COUNTER_KEY,scoreCounter);
        outState.putInt(BACKGROUND_COLOR_KEY,mBackgroundColor);
    }

}
