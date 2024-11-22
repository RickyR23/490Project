package com.example.legatoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.legatoapp.databinding.ActivityUserLoginBinding;

public class userLoginActivity extends AppCompatActivity {

    private ActivityUserLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button launch_to_home = findViewById(R.id.launch_tohomepage);
        launch_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeActivity();
                finish();
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

    private void sendLogin(username,password)
    {
        ProcessBuilder pb = new ProcessBuilder("python", "checklogin.py");
        Process process = pb.start();
        try (PrintWriter writer = new PrintWriter(process.getOutputStream())) 
        {
            writer.println(username); //send username
            write.println(password) //sendpassword
            writer.flush();
        }
    }

    private void checklogin(username, password) //temp maybe?
    {
        if(username.equals('admin') && password.equals('password') )
        {
            return true
        }
        else
        {
            return false
        }
    }
}

