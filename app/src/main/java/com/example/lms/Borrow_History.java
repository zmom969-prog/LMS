package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.adapter.BorrowHistoryAdapter;
import com.example.lms.model.BorrowHistoryModel;

import java.util.ArrayList;
import java.util.List;

public class Borrow_History extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BorrowHistoryAdapter adapter;
    private ImageView btnBack;
    private Spinner spinnerFilter;
    private LinearLayout navHome, navBook, navBorrow, navProfile;
    private List<BorrowHistoryModel> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_history);

        // ភ្ជាប់ ID ពី XML
        btnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recyclerViewHistory);
        spinnerFilter = findViewById(R.id.spinnerFilter);

        navHome = findViewById(R.id.navHome);
        navBook = findViewById(R.id.navBook);
        navBorrow = findViewById(R.id.navBorrow);
        navProfile = findViewById(R.id.navProfile);
        btnBack = findViewById(R.id.btnBack);

        // កំណត់ទម្រង់ RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // កំណត់ទិន្នន័យឱ្យ Spinner ("Next 30 days")
        String[] filterOptions = {"Next 30 days", "Past 30 days", "All History"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, filterOptions);
        spinnerFilter.setAdapter(spinnerAdapter);

        // បញ្ចូលទិន្នន័យគំរូ (Sample Data ស្របតាមរូបភាព)[cite: 7]
        historyList = new ArrayList<>();
        historyList.add(new BorrowHistoryModel("Friday, 30 July 2026", "00:00", "Tuesdays with Morrie", "Tuesday, 4 July 2026 - Friday, 30 July 2026", R.drawable.ic_launcher_foreground));
        historyList.add(new BorrowHistoryModel("Friday, 30 July 2026", "00:00", "Good Girl Bad Blood", "Tuesday, 4 July 2026 - Friday, 30 July 2026", R.drawable.ic_launcher_foreground));
        historyList.add(new BorrowHistoryModel("Friday, 30 July 2026", "00:00", "Normal People Sally Rooney", "Tuesday, 4 July 2026 - Friday, 30 July 2026", R.drawable.ic_launcher_foreground));

        adapter = new BorrowHistoryAdapter(historyList);
        recyclerView.setAdapter(adapter);

        // ព្រឹត្តិការណ៍ចុចលើ Bottom Navigation
        navHome.setOnClickListener(v -> {
            // Intent intent = new Intent(BorrowHistoryActivity.this, HomeActivity.class);
            // startActivity(intent);
        });

        navBook.setOnClickListener(v -> {
            // Intent intent = new Intent(BorrowHistoryActivity.this, BookActivity.class);
            // startActivity(intent);
        });

        navBorrow.setOnClickListener(v -> {
            // បច្ចុប្បន្នស្ថិតនៅទំព័រនេះស្រាប់
        });

        navProfile.setOnClickListener(v -> {
            // Intent intent = new Intent(BorrowHistoryActivity.this, Profile.class);
            // startActivity(intent);
        });

        // ព្រឹត្តិការណ៍ Back

        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(Borrow_History.this, Notification.class);
            startActivity(i);
        });
    }
}