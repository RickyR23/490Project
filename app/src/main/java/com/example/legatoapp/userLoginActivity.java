package com.example.legatoapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.legatoapp.databinding.ActivityUserLoginBinding;

public class userLoginActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityUserLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button launch_to_home = (Button)findViewById(R.id.launch_tohomepage);
        launch_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchhomeactivity();
                finish();

            }
        });
    }

private void launchhomeactivity(){
    Intent intent = new Intent(userLoginActivity.this, userHome.class);
    startActivity(intent);
}

}