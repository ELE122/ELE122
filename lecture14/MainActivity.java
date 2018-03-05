package com.netwurke.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // This is runned by Android when this activity started
    // Since we stated in the manifest that this activity should be
    // the first to start in our application, this code will run when
    // the application starts.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Call constructor of superclass
        super.onCreate(savedInstanceState);

        // Tell android to display buttons/fields/etc. in our layout
        setContentView(R.layout.activity_main);
    }

    // This is called when the login-button is clicked
    public void login(View view) {
        Log.i("MainActivity", "Login button was clicked");

        // Get references to EditText objects on the screen
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        // Get the text-content of the EditText objects
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Log the contents to verify
        Log.i("MainActivity", "Username: " + username + ", password: " + password);

        // Create an intent object - showing our intentions to start the LobbyActivity
        Intent intentToStartTheLobbyActivity = new Intent(this, LobbyActivity.class);

        // Start the activity by passing the intent object to Android
        startActivity(intentToStartTheLobbyActivity);
    }
}

