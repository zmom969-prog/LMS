
package com.example.lms;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public class Settings extends AppCompatActivity {

    private TextView btnBack, tvTitle, tvProfileName;

    private ShapeableImageView imgProfile;

    private MaterialCardView cardMyProfile,
            cardGroupPreferences,
            cardLanguage;

    private LinearLayout layoutNotification,
            layoutPrivacy,
            layoutMemories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnBack = findViewById(R.id.btnBack);
        tvTitle = findViewById(R.id.tvTitle);
        imgProfile = findViewById(R.id.imgProfile);
        tvProfileName = findViewById(R.id.tvProfileName);

        cardMyProfile = findViewById(R.id.cardMyProfile);
        cardGroupPreferences =
                findViewById(R.id.cardGroupPreferences);
        cardLanguage = findViewById(R.id.cardLanguage);

        layoutNotification =
                findViewById(R.id.layoutNotifications);
        layoutPrivacy = findViewById(R.id.layoutPrivacy);
        layoutMemories = findViewById(R.id.layoutMemories);

        // Back to Profile
        btnBack.setOnClickListener(v -> finish());
    }
}
