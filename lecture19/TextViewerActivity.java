package com.example.installer.storingtextintext;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TextViewerActivity extends AppCompatActivity {
    //TextView-handle to retrieve display text read from file
    private TextView mDisplayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_viewer);
        //Intializing handle to text view
        mDisplayText = findViewById(R.id.textView);
    }

    /**
     * ON CLICK METHODS
     */
    
    //BUTTON: read internal
    public void readInternalButtonClicked(View view){

        //Gets a file object representing the internal directory
        File path = getFilesDir(); ///data/user/0/com.example.installer.storingtextintext/files
        File file = new File(path,"MyInternalFile.txt");
        try {
            //Reads file, converts to String, and updates text view
           mDisplayText.setText(fileToString(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //BUTTON: read external
    public void readExternalButtonClicked(View view){
        //Get a handle to external directory
        File path =  getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path,"MyExternalFile.txt");

        try {
            //Reads file, converts to String, and updates text view
            mDisplayText.setText(fileToString(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that reads all bytes of a the specified file and turns it into a String
     * @param file object holding the abolute path to the fil to read
     * @return the file content as a String object
     * @throws IOException
     */
    private String fileToString(File file)throws IOException{
        String text = "";

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
        int data;
        //Read byte by byte into buffer
        while ((( data = bufferedInputStream.read()) != -1)){
            byteArrayOutputStream.write(data);
        }

        //Convert buffer into string
        if (byteArrayOutputStream != null)
            text = byteArrayOutputStream.toString();

        return text;
    }
}

