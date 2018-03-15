package com.netwurke.arur.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MyService";

    public MyService() {
    }

    // onBind() is used when we want a bound service
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // onStartCommand() is called by Android when startService() is called (see Service lifecycle)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service starting");
        Toast.makeText(this, "Service starting", Toast.LENGTH_LONG).show();

        // Sleep and log to illustrate
        // 1) It blocks UI/main thread.
        // 2) It is not terminated when app is terminated
        for(int i = 1; i < 11; i++) {
            try {
                Thread.sleep(2000);
                Log.i(TAG, "Iteration " + i + " in service");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service destroyed");
        Toast.makeText(this, "Service stopping", Toast.LENGTH_SHORT).show();
    }
}
