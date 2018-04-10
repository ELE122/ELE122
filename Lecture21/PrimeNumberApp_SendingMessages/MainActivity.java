package com.example.installer.primenumbermessages;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyHandler mHandler;
    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler =  new MyHandler(); //handler will point to UI thread
        mTextView =  findViewById(R.id.textView);
        mEditText =  findViewById(R.id.editText);
    }

    public void buttonClicked(View view){
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
                Message msg;
                //Let the "UI thread handler" know that work has started
                msg = mHandler.obtainMessage(MyHandler.WORK_STARTED);
                mHandler.sendMessage(msg);

                //Simulate extra working time
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Perform heavy duty calculation
                boolean isPrime = isNumberPrime(number);

                //Let the "UI thread handler" know the result
                if(isPrime){
                    msg = mHandler.obtainMessage(MyHandler.RESULT_TRUE, number);
                }else{
                    msg = mHandler.obtainMessage(MyHandler.RESULT_FALSE, number);
                }

                mHandler.sendMessage(msg);


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

    private class MyHandler extends Handler {
        public static final int WORK_STARTED = 0;
        public static final int RESULT_TRUE = 1;
        public static final int RESULT_FALSE = 2;

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case WORK_STARTED:
                    Toast.makeText(
                            MainActivity.this,"Work started", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_FALSE:
                    mTextView.setText((int)msg.obj + " is NOT a prime number");
                    break;
                case RESULT_TRUE:
                    mTextView.setText((int)msg.obj + " IS a prime number");
                    break;
            }
        }

    }


}
