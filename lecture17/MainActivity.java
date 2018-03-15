package com.netwurke.arur.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startServiceButtonClick(View view) {

        // Sleep and log to illustrate activity is terminated when app is terminated
        for(int i = 1; i < 11; i++) {
            try {
                Thread.sleep(2000);
                Log.i(TAG, "Iteration " + i + " in activity");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        startMyService();
    }

    public void stopServiceButtonClick(View view) {
        stopMyService();
    }

    private void startMyService() {
        Intent intentToStartService = new Intent(this, MyService.class);
        startService(intentToStartService);
    }

    private void stopMyService() {
        Intent intentToStartService = new Intent(this, MyService.class);
        stopService(intentToStartService);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity destroyed");
    }
}
