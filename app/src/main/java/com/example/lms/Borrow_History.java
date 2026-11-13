package com.example.lms;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lms.adapter.BorrowHistoryAdapter;
import com.example.lms.model.BorrowHistoryModel;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Borrow_History extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BorrowHistoryAdapter adapter;
    private List<BorrowHistoryModel> historyList;
    private Spinner spinnerFilter;
    private ImageView btnBack;
    private TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_history);

        // Intent back
        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(Borrow_History.this, Profile.class);
            startActivity(i);
        });

        // Setup Back Button action
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close activity and go back
            }
        });

        // Setup Spinner Dropdown Filter options
        String[] filters = new String[]{"Next 30 days", "Past 3 months", "All time"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, filters);
        spinnerFilter.setAdapter(spinnerAdapter);

        // Populate mock data matching the screenshot design[cite: 1]
        historyList = new ArrayList<>();
        historyList.add(new BorrowHistoryModel(
                "Friday, 30 July 2026",
                "00:00",
                R.drawable.ic_launcher_background, // Replace with your book cover drawable (e.g., R.drawable.tuesdays_with_morrie)
                "Tuesdays with Morrie",
                "Tuesday, 4 July 2026 - Friday, 30 July 2026"
        ));
        historyList.add(new BorrowHistoryModel(
                "Friday, 30 July 2026",
                "00:00",
                R.drawable.ic_launcher_background,
                "Good Girl Bad Blood",
                "Tuesday, 5July 2026 - Friday, 30 July 2026"
        ));
        historyList.add(new BorrowHistoryModel(
                "Friday, 30 July 2026",
                "00:00",
                R.drawable.ic_launcher_background,
                "Normal People Sally Rooney",
                "Tuesday, 4 July 2026 - Friday, 30 July 2026"
        ));


    }
}