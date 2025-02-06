package com.example.legatoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.legatoapp.databinding.ActivityUserLoginBinding;

public class userLoginActivity extends AppCompatActivity {

    private ActivityUserLoginBinding binding;
    private String userInputString;
    private String passwordInputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("LegatoPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            launchHomeActivity();
            finish();
            return;
        }

        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button launch_to_home = findViewById(R.id.launch_tohomepage);
        launch_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameInput = findViewById(R.id.username);
                EditText passwordInput = findViewById(R.id.loginPassword);
                userInputString = usernameInput.getText().toString();
                passwordInputString = passwordInput.getText().toString();

                Boolean checkLoginValidity = checklogin(userInputString, passwordInputString);
                Log.d("checkLoginValidity", "is true?: " + checkLoginValidity);
                if (checkLoginValidity) {
                    saveLoginState(); // Save login status
                    launchHomeActivity();
                    finish();
                } else {
                    Toast.makeText(userLoginActivity.this, "Login Unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button launch_to_signup = findViewById(R.id.launch_tosignuppage);
        launch_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSignupActivity();
                finish();
            }
        });

        TextView forgotPasswordText = findViewById(R.id.forgotPasswordText);
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchForgotPasswordActivity();
            }
        });
    }

    private void launchHomeActivity() {
        Intent intent = new Intent(userLoginActivity.this, userHome.class);
        startActivity(intent);
    }

    private void launchSignupActivity() {
        Intent intent = new Intent(userLoginActivity.this, signUp.class);
        startActivity(intent);
    }

    private void launchForgotPasswordActivity() {
        Intent intent = new Intent(userLoginActivity.this, forgetPassword.class);
        startActivity(intent);
    }

    private Boolean checklogin(String username, String password) {
        // Mock login credentials
        String mockUsername = "admin";
        String mockPassword = "password";
        Log.d("checkLogin", "mockUser: " + mockUsername + "\ninputUser: " + username + "\n mockPass: " + mockPassword + "\n inputPass: " + password);

        return username.equals(mockUsername) && password.equals(mockPassword);
    }

    private void saveLoginState() {
        SharedPreferences sharedPreferences = getSharedPreferences("LegatoPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }
}
