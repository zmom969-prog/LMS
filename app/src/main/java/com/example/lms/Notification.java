package com.example.lms; // សូមប្តូរឈ្មោះ package តាមប្រព័ន្ធរបស់អ្នក

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;
import com.example.lms.adapter.NotificationAdapter;
import com.example.lms.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationModel> notificationList;
    private ImageView btnBack, btnSettings;






    // ប្រកាស Bottom Navigation variables
    private LinearLayout navHome, navBook, navBorrow, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // ១. ត្រួតពិនិត្យនិងកំណត់ប៊ូតុង Back (ថយក្រោយ)
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // ២. កំណត់ RecyclerView និងទិន្នន័យ Notification
        recyclerView = findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notificationList = new ArrayList<>();

        // បញ្ចូលទិន្នន័យ Notification តាមរូបរចនា (Design)[cite: 1]
        notificationList.add(new NotificationModel(
                "Atomic Habits",
                "Due on sept 30. Tap below to extend your borrow period for 15 days more.",
                "Yesterday",
                Color.parseColor("#EF6C64") // ពណ៌ក្រហម/ផ្កាឈូក
        ));

        notificationList.add(new NotificationModel(
                "The Little Prince",
                "Due on sept 30. Tap below to extend your borrow period for 15 days more.",
                "Yesterday",
                Color.parseColor("#E452D6") // ពណ៌ផ្កាឈូកម៉ង់សែ
        ));

        notificationList.add(new NotificationModel(
                "Ikigai",
                "Due on sept 30. Tap below to extend your borrow period for 15 days more.",
                "Yesterday",
                Color.parseColor("#5AABEE") // ពណ៌ខៀវ
        ));

        notificationList.add(new NotificationModel(
                "Dune",
                "Due on sept 30. Tap below to extend your borrow period for 15 days more.",
                "Yesterday",
                Color.parseColor("#9C9490") // ពណ៌ប្រផេះ
        ));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        // ៣. ភ្ជាប់ ID របស់ Bottom Navigation ពី XML
        navHome = findViewById(R.id.navHome);
        navBook = findViewById(R.id.navBook);
        navBorrow = findViewById(R.id.navBorrow);
        navProfile = findViewById(R.id.navProfile);
        btnBack = findViewById(R.id.btnBack);
        btnSettings = findViewById(R.id.btnSettings);

        // ៤. កំណត់ព្រឹត្តិការណ៍ Click សម្រាប់ប្តូរទំព័រតាម Bottom Navigation
        navHome.setOnClickListener(v -> {
            // Intent intent = new Intent(NotificationActivity.this, HomeActivity.class);
            // startActivity(intent);
            // finish();
        });

        navBook.setOnClickListener(v -> {
            // Intent intent = new Intent(NotificationActivity.this, BookActivity.class);
            // startActivity(intent);
            // finish();
        });

        navBorrow.setOnClickListener(v -> {
            // Intent intent = new Intent(NotificationActivity.this, BorrowActivity.class);
            // startActivity(intent);
            // finish();
        });

        navProfile.setOnClickListener(v -> {
            // Intent intent = new Intent(NotificationActivity.this, ProfileActivity.class);
            // startActivity(intent);
            // finish();
        });

        // Intent

        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(Notification.this, Profile.class);
            startActivity(i);
        });

        btnSettings.setOnClickListener(v -> {
            Intent i = new Intent(Notification.this, Settings.class);
            startActivity(i);
        });


    }




}