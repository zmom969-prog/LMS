
package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reading extends AppCompatActivity {

    TextView btnBack;
    TextView txtTitle, txtDescription;

    ImageView imgBook, btnFavorite;

    Button btnBorrow, btnRead;

    LinearLayout navHome, navBook, navBorrow, navProfile;

    boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        // Connect XML Views
        btnBack = findViewById(R.id.btnBack);

        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);

        imgBook = findViewById(R.id.imgBook);
        btnFavorite = findViewById(R.id.btnFavorite);

        btnBorrow = findViewById(R.id.btnBorrow);
        btnRead = findViewById(R.id.btnRead);

        navHome = findViewById(R.id.navHome);
        navBook = findViewById(R.id.navBook);
        navBorrow = findViewById(R.id.navBorrow);
        navProfile = findViewById(R.id.navProfile);

        // Book Information
        txtTitle.setText("Atomic Habits");

        txtDescription.setText(
                "Atomic Habits by James Clear.\n\n" +
                        "An Easy & Proven Way to Build Good Habits " +
                        "and Break Bad Ones."
        );

        imgBook.setImageResource(R.drawable.book);

        // Back Button
        btnBack.setOnClickListener(v -> {
            finish();
        });

        // Favorite Button
        btnFavorite.setOnClickListener(v -> {

            isFavorite = !isFavorite;

            if (isFavorite) {

                btnFavorite.setImageResource(
                        R.drawable.heart_icon
                );

                Toast.makeText(this,
                        "Added to Favorite",
                        Toast.LENGTH_SHORT).show();

            } else {

                btnFavorite.setImageResource(
                        R.drawable.heart_icon
                );

                Toast.makeText(this,
                        "Removed from Favorite",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Borrow Button
        btnBorrow.setOnClickListener(v -> {

            Toast.makeText(this,
                    "Borrow Book Successfully!",
                    Toast.LENGTH_SHORT).show();

        });


        // Intent

        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(Reading.this, Borrow_History.class);
            startActivity(i);
        });

    }
}
