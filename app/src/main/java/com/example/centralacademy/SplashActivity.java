package com.example.centralacademy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView; // Import GifImageView

public class SplashActivity extends AppCompatActivity {

    private GifImageView gifImageView; // Declare GifImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // Initialize the GifImageView
        gifImageView = findViewById(R.id.gifImageView); // Make sure this ID matches your XML layout

        // Start playing the GIF
        gifImageView.setVisibility(GifImageView.VISIBLE); // Ensure it's visible

        // Create an Intent to start MainActivity
        Intent iHome = new Intent(SplashActivity.this, MainActivity.class);

        // Use Handler to delay the transition to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iHome);
                finish(); // Finish SplashActivity so it's removed from the back stack
            }
        }, 3000); // Delay in milliseconds (3000ms = 3 seconds)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Optional: Clean up any resources if needed
    }
}
