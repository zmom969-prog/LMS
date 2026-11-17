package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
    private TextView backButton;
    private Button btnEditeProfile, btnSittings, btnLanguage, btnNotifications, btnPrivacy, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btnEditeProfile = findViewById(R.id.btnEditProfile);
        btnSittings = findViewById(R.id.btnSettings);
        btnLanguage = findViewById(R.id.btnLanguage);
        btnNotifications = findViewById(R.id.btnNotifications);
        btnPrivacy = findViewById(R.id.btnPrivacy);
        btnLogout = findViewById(R.id.btnLogout);
        backButton = findViewById(R.id.backButton);

        //Intent

        btnEditeProfile.setOnClickListener(v -> {
            Intent i = new Intent(
                    Profile.this,
                    EditeProfile.class
            );
            startActivity(i);
        });

        btnSittings.setOnClickListener(v -> {
            Intent intent = new Intent(Profile.this, Settings.class);
            startActivity(intent);
        });

        backButton.setOnClickListener(v -> {
            Intent i = new Intent(Profile.this, MainActivity.class);
            startActivity(i);
        });


        btnLogout.setOnClickListener(v -> {
            Intent i = new Intent(Profile.this, Reading.class);
            startActivity(i);
        });


       btnNotifications.setOnClickListener(v -> {
           Intent i = new Intent(Profile.this, Notification.class);
           startActivity(i);
       });


        btnPrivacy.setOnClickListener(v -> {
            Intent i = new Intent(Profile.this, FavoriteBook.class);
            startActivity(i);
        });
    }

}