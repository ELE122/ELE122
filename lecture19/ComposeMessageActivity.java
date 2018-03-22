package com.example.installer.storingtextintext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ComposeMessageActivity  extends AppCompatActivity {
    private final String TAG = "MainActivity";
    
    //EditText-handle to retrieve user-entered text
    private EditText mInputText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize member
        mInputText = findViewById(R.id.editText2);
    }

    /**
     * On click methods
     */

    //BUTTON: "Open Viewer" starts TextViewerActivity
    public void startTextViewer(View view){
        Intent intent = new Intent(this,TextViewerActivity.class);
        startActivity(intent);
    }


    //BUTTON: Save internally
    public void saveInternalButtonClicked(View view) {
        String textToStore =  mInputText.getText().toString(); //Retrieve the entered text
        mInputText.setText("");

        //Get a file object representing the internal directory
        File path = getFilesDir(); ///data/user/0/com.example.installer.storingtextintext/files
        File file = new File(path,"MyInternalFile.txt");
                ///data/user/0/com.example.installer.storingtextintext/files/MyFile.txt
        
        try {
            writeToFile(file,textToStore); //Write to file
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    //BUTTON: Saving Externally
    public void saveExternalButtonClicked(View view){
            String textToStore =  mInputText.getText().toString();//Retrieve the entered text
            mInputText.setText("");
            
            //Get a file object representing the external directory /Documents
            File path =  getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(path,"MyExternalFile.txt");
        try {
            writeToFile(file, textToStore);//Write to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method to write to file
    private void writeToFile(File file, String text) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(text.getBytes());
    }

    //Method that APPENDS data to existing content in the specified file
    private void writeToFileAppend(File file, String text) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write(text.getBytes());
    }


}
