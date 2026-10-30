package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatExtras;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditeProfile extends AppCompatActivity {
private TextView btnBack, profileName;
private EditText etName,etUsername, etBirthday,etNumber;
private Button btnAddAccount, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edite_profile);


        btnBack= findViewById(R.id.btnBack);
        profileName = findViewById(R.id.profileName);
        etName = findViewById(R.id.etName);
        etBirthday = findViewById(R.id.etBirthday);
        etNumber = findViewById(R.id.etNumber);
        btnAddAccount = findViewById(R.id.btnAddAccount);
        btnLogout = findViewById(R.id.btnLogout);

        // Intent

        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(
                    EditeProfile.this,
                    Profile.class
            );
            startActivity(i);
        });
    }
}