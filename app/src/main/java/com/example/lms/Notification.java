package com.example.lms;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lms.adapter.NotificationAdapter;
import com.example.lms.model.NotificationModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationModel> notificationList;
    private TextView tvUnreadBadge;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView = findViewById(R.id.recyclerNotification);
        tvUnreadBadge = findViewById(R.id.tvUnreadBadge);
        ImageView btnBack = findViewById(R.id.btnBack);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        // ប៊ូតុងថយក្រោយ
        btnBack.setOnClickListener(v -> finish());

        // បញ្ចូលទិន្នន័យ Notification ជាមួយពណ៌តាមទម្រង់ក្នុងរូបភាព
        notificationList = new ArrayList<>();
        String defaultMsg = "Due on sept 30. tap below to extend your borrow period for 15 days more";

        notificationList.add(new NotificationModel("Atomic Habits", defaultMsg, "Yesterday", Color.parseColor("#E96B68"))); // ក្រហមផ្កាឈូក
        notificationList.add(new NotificationModel("The Little Prince", defaultMsg, "Yesterday", Color.parseColor("#E96CEB"))); // ស្វាយផ្កាឈូក
        notificationList.add(new NotificationModel("Ikigai", defaultMsg, "Yesterday", Color.parseColor("#71B7EE"))); // ខៀវស្រាល
        notificationList.add(new NotificationModel("Dune", defaultMsg, "Yesterday", Color.parseColor("#A59C9C"))); // ប្រផេះត្នោត

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ភ្ជាប់ Adapter ជាមួយមុខងារចុចលើ Card (ពន្យារពេល) និងចុចលុប (X)
        adapter = new NotificationAdapter(notificationList, remainingCount -> {
            tvUnreadBadge.setText(remainingCount + " Unread");
        }, (item, position) -> {
            // Dialog បង្ហាញពេលចុចលើ Card
            new AlertDialog.Builder(this)
                    .setTitle("Extend Borrow Period")
                    .setMessage("Do you want to extend borrow period for " + item.getTitle() + " by 15 days more?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(this, "Extended successfully for " + item.getTitle(), Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        recyclerView.setAdapter(adapter);

        // ការគ្រប់គ្រងការចុចលើ BottomNavigationView ស្ដង់ដារ
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_book) {
                Toast.makeText(this, "Book Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_borrow) {
                Toast.makeText(this, "Borrow Clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_profile) {
                Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }
}