package com.example.legatoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the ActionBar programmatically
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_splashscreen);

        // Delay for the splash screen (3 seconds) before transitioning to the login screen
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splashScreen.this, userLoginActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish(); // Finish splash activity to remove it from back stack
        }, 2000); // 2000 milliseconds = 2 seconds
    }

}
