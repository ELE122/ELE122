package com.example.installer.logginglifecycleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/*
This activity
 */
public class MainActivity extends AppCompatActivity {
    //TAG for writing to Log.i
    public static final String TAG =  "MainActivity";//String key to be used for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Assumes the existence of activity_main.xml

        Log.i(TAG,"Called onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Called onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Called onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Called onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Called onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Called onDestroy");
    }

    //This method is activated by the click of a button
    public void onClickNextActivityButton(View view){
        Intent intent =  new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

}
