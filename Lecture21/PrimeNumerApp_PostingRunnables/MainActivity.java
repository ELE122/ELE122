package com.example.installer.primenumbershandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler =  new Handler(); //handler will point to UI thread
        mTextView =  findViewById(R.id.textView);
        mEditText =  findViewById(R.id.editText);

    }


    /**
     * Extracts entered number and runs isPrimeNumber() in a worker thread()
     * @param view - This is an onClick() method
     */
    public void checkPrimeButtonClicked(View view){
        //Get the input from user
        String text = mEditText.getText().toString();

        if(text.equals("")){
            Toast.makeText(this,"Enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        final int number = Integer.parseInt(text);

        //Create a background thread
        new Thread(new Runnable() {

            @Override
            public void run() {
                final boolean isPrime = isNumberPrime(number);

                //Uses Handlers post() method to schedule runnable to be run on the UI-thread
                //Lets the user know the result
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                       if(isPrime){
                           mTextView.setText(number + " is a prime number");
                       }else{
                           mTextView.setText(number + " is NOT a prime number");
                       }
                    }
                });
            }
        }).start();

    }


    /**
     * Method to check for prime number
     * @param i -  the number to be validated for prime
     * @return true if the number is prime, false if not
     */
    public static boolean isNumberPrime(int i) {
        int factors = 0;
        int j = 1;
        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }

}
