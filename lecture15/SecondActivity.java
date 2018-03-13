package com.example.installer.logginglifecycleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class SecondActivity extends AppCompatActivity {
    public static final String TAG =  "SecondActivity";//String key to be used for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);////Assumes the existence of activity_second.xml
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
        Log.i(TAG,"Called onResume");
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
}
