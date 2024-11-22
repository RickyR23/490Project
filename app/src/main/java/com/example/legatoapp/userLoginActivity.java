package com.example.legatoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
                if(checkLoginValidity){
                    launchHomeActivity();
                    finish();
                }
                else{
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

//    private void sendLogin(username,password) //sends to python scipt to check login //DB in future //might not keep
//    {
//        ProcessBuilder pb = new ProcessBuilder("python", "checklogin.py");
//        Process process = pb.start();
//        try (PrintWriter writer = new PrintWriter(process.getOutputStream()))
//        {
//            writer.println(username); //send username
//            write.println(password) //sendpassword
//            writer.flush();
//        }
//    }

    private Boolean checklogin(String username, String password){
        String mockUsername = "admin";
        String mockPassword = "password";
        Log.d("checkLogin", "mockUser: " + mockUsername + "\ninputUser: " + username + "\n mockPass: " + mockPassword + "\n inputPass: " + password);
        if(username.equals(mockUsername) && password.equals(mockPassword)){
            return true; //continue to home page
        }
        else{
            return false; //stay in login page
        }
    }
}

