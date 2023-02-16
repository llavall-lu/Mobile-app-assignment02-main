package com.example.ticketapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ticketapplication.MainActivity;
import com.example.ticketapplication.R;
import com.example.ticketapplication.databinding.ActivityWelcomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void register(View view) {
        startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class)); //Changes the current activity "WelcomeActivity to RegistrationActivity"
    }

    public void login(View view) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));   //Changes the current activity "WelcomeActivity to LoginActivity"
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));        //Checks for user login, if user is confirmed directs them straight to the MainActivity, if not continues to WelcomeActivity as usual
            finish();
        }
    }
}
