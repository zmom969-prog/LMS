package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.adapter.FavoriteBookAdapter;
import com.example.lms.model.FavoriteBookModel;
import java.util.ArrayList;
import java.util.List;

public class FavoriteBook extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FavoriteBookAdapter adapter;
    private ImageView btnBack;
    private List<FavoriteBookModel> favoriteList;

    // ប្រកាសអុជបាយសម្រាប់ LinearLayout Bottom Navigation
    private LinearLayout navHome, navBook, navBorrow, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritebook);

        // ភ្ជាប់ ID ពី XML
        btnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recyclerViewFavorites);

        // ភ្ជាប់ ID របស់ Bottom Navigation (LinearLayout)
        navHome = findViewById(R.id.navHome);
        navBook = findViewById(R.id.navBook);
        navBorrow = findViewById(R.id.navBorrow);
        navProfile = findViewById(R.id.navProfile);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // បញ្ចូលទិន្នន័យគំរូ (Sample Data)
        favoriteList = new ArrayList<>();
        favoriteList.add(new FavoriteBookModel("Harry Potter", "J.K. Rowling", R.drawable.ic_launcher_foreground));
        favoriteList.add(new FavoriteBookModel("Harry Potter", "J.K. Rowling", R.drawable.ic_launcher_foreground));
        favoriteList.add(new FavoriteBookModel("Harry Potter", "J.K. Rowling", R.drawable.ic_launcher_foreground));

        adapter = new FavoriteBookAdapter(favoriteList, new FavoriteBookAdapter.OnItemClickListener() {
            @Override
            public void onBorrowClick(int position) {
                Toast.makeText(FavoriteBook.this, "Borrowing: " + favoriteList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFavoriteClick(int position) {
                favoriteList.remove(position);
                adapter.notifyItemRemoved(position);
                Toast.makeText(FavoriteBook.this, "Removed from Favorites", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);

        // គ្រប់គ្រងព្រឹត្តិការណ៍ចុចលើ Bottom Navigation (LinearLayout)
        navHome.setOnClickListener(v -> {
            // Intent intent = new Intent(FavoriteBook.this, HomeActivity.class);
            // startActivity(intent);
            // finish();
            Toast.makeText(FavoriteBook.this, "Clicked Home", Toast.LENGTH_SHORT).show();
        });

        navBook.setOnClickListener(v -> {
            // Intent intent = new Intent(FavoriteBook.this, BookActivity.class);
            // startActivity(intent);
            // finish();
            Toast.makeText(FavoriteBook.this, "Clicked Book", Toast.LENGTH_SHORT).show();
        });

        navBorrow.setOnClickListener(v -> {
            // Intent intent = new Intent(FavoriteBook.this, BorrowActivity.class);
            // startActivity(intent);
            // finish();
            Toast.makeText(FavoriteBook.this, "Clicked Borrow", Toast.LENGTH_SHORT).show();
        });

        navProfile.setOnClickListener(v -> {
            // Intent intent = new Intent(FavoriteBook.this, Profile.class);
            // startActivity(intent);
            // finish();
            Toast.makeText(FavoriteBook.this, "Clicked Profile", Toast.LENGTH_SHORT).show();
        });

        // ព្រឹត្តិការណ៍ចុចលើប៊ូតុង Back (ត្រឡប់ក្រោយ)
        btnBack.setOnClickListener(v -> {
            Intent i = new Intent(FavoriteBook.this, Profile.class);
            startActivity(i);
            finish();
        });
    }
}