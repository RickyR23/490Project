package com.example.legatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.net.URI;

public class signUp extends AppCompatActivity {

    private static final String CLIENT_ID = ""; //Always Delete these values prior to pushing to online repo
    private static final String CLIENT_SECRET = ""; //Always Delete these values prior to pushing to online repo
    private static final String REDIRECT_URI = ""; //Always Delete these values prior to pushing to online repo
    private static final String SCOPES = "user-read-playback-state user-read-currently-playing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageButton backToLogInButton = findViewById(R.id.backToLogInButton);
        backToLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this, userLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button connectSpotifyButton = findViewById(R.id.buttonConnectSpotify);
        connectSpotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSpotifyAuthSession();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Uri receivedUri = getIntent().getData();

        if(receivedUri != null && receivedUri.toString().startsWith(REDIRECT_URI)){
            String authCode = receivedUri.getQueryParameter("code");
            if(authCode != null){

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void launchSpotifyAuthSession(){
        Uri authenticationURI = new Uri.Builder()
                .scheme("https")
                .authority("accounts.spotify.com")
                .appendPath("authorize")
                .appendQueryParameter("client_id",CLIENT_ID)
                .appendQueryParameter("response_type", "code")
                .appendQueryParameter("redirect_uri", REDIRECT_URI)
                .appendQueryParameter("scope", SCOPES)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW, authenticationURI);
        startActivity(intent);
    }



}