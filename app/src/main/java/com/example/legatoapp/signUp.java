package com.example.legatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageButton backToLogInButton = findViewById(R.id.backToLogInButton);
        backToLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the LoginActivity
                Intent intent = new Intent(signUp.this, userLoginActivity.class);

                // Start the LoginActivity
                startActivity(intent);
                 // TEST CHANGES
                //TEST CHANGE
                //TEST CHANGE
                // Finish the current activity to remove it from the back stack
                finish();
            }
        });
    }
}