package com.example.installer.forresultsapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * author: Espen Nilsen
 *
 * Activity that returns a result.
 * Has 3 buttons:
 *      *each of which ads a color choice to the result intent (setResult())
 */

public class PickAndChooseActivity extends AppCompatActivity {
    //String key for EXTRA data in result intent
    //I make this constant public so that MainActivity can refer to it directly
    public static final String EXTRA_COLOR_CHOICE = "com.example.installer.forresultsapp.COLOR_CHOICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_and_choose);
    }

    /*
    ON CLICK METHODS
     */
    public void chooseGreen(View view){
        Intent intent =  new Intent();
        intent.putExtra(EXTRA_COLOR_CHOICE,getResources().getColor(R.color.colorEspenGreen));
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void chooseBlue(View view){
        Intent intent =  new Intent();
        intent.putExtra(EXTRA_COLOR_CHOICE,getResources().getColor(R.color.colorEspenBlue));
        setResult(Activity.RESULT_OK, intent);
        finish();//Ends this activity

    }

    public void choosePink(View view){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_COLOR_CHOICE,getResources().getColor(R.color.colorEspenPink));
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
