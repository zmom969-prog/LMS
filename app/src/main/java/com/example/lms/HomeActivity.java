package com.example.lms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.adapter.BookAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private EditText edtSearch;
    private ImageView icFavorite, icNotification, icSettings;
    private TextView tvSeeAllNew, tvSeeAllBook;
    private RecyclerView rvNewBooks, rvBooks;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Keep content out from under the status / navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupBookLists();
        setupClickListeners();
        setupBottomNav();
    }

    private void initViews() {
        edtSearch = findViewById(R.id.edtSearch);
        icFavorite = findViewById(R.id.icFavorite);
        icNotification = findViewById(R.id.icNotification);
        icSettings = findViewById(R.id.icSettings);
        tvSeeAllNew = findViewById(R.id.tvSeeAllNew);
        tvSeeAllBook = findViewById(R.id.tvSeeAllBook);
        rvNewBooks = findViewById(R.id.rvNewBooks);
        rvBooks = findViewById(R.id.rvBooks);
        bottomNav = findViewById(R.id.bottomNav);
    }

    private void setupBookLists() {
        // Sample data. Replace the cover with your own drawable, for example R.drawable.ikigai
        int cover = R.drawable.ic_launcher_background;

        List<Book> newBooks = new ArrayList<>();
        newBooks.add(new Book("Ikigai", "Hector Garcia and Francesc Miralles", cover, true));
        newBooks.add(new Book("The Little Prince", "Antoine de Saint-Exupery", cover, true));
        newBooks.add(new Book("Tuesdays with Morrie", "Mitch Albom", cover, true));

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", cover, true));
        books.add(new Book("Harry Potter", "J. K. Rowling", cover, true));
        books.add(new Book("Dune", "Frank Herbert", cover, false));

        rvNewBooks.setAdapter(new BookAdapter(newBooks, book ->
                Toast.makeText(this, book.getTitle(), Toast.LENGTH_SHORT).show()));
        rvBooks.setAdapter(new BookAdapter(books, book ->
                Toast.makeText(this, book.getTitle(), Toast.LENGTH_SHORT).show()));
    }

    private void setupClickListeners() {
        // The search field only opens the search screen, so it must not take focus here
        edtSearch.setFocusable(false);
        edtSearch.setOnClickListener(v ->
                startActivity(new Intent(this, SearchActivity.class)));

        icFavorite.setOnClickListener(v ->
                startActivity(new Intent(this, FavoriteActivity.class)));

        icNotification.setOnClickListener(v ->
                startActivity(new Intent(this, NotificationActivity.class)));

        icSettings.setOnClickListener(v ->
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show());

        tvSeeAllNew.setOnClickListener(v ->
                startActivity(new Intent(this, AllBookActivity.class)));

        tvSeeAllBook.setOnClickListener(v ->
                startActivity(new Intent(this, AllBookActivity.class)));
    }

    private void setupBottomNav() {
        bottomNav.setSelectedItemId(R.id.nav_home);

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_book) {
                startActivity(new Intent(this, AllBookActivity.class));
                return true;
            } else if (id == R.id.nav_borrow) {
                startActivity(new Intent(this, BorrowHistoryActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }
}