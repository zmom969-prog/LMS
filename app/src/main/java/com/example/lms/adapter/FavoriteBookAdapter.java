package com.example.lms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;
import com.example.lms.model.FavoriteBookModel;

import java.util.List;

public class FavoriteBookAdapter extends RecyclerView.Adapter<FavoriteBookAdapter.ViewHolder> {

    private List<FavoriteBookModel> bookList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onBorrowClick(int position);
        void onFavoriteClick(int position);
    }

    public FavoriteBookAdapter(List<FavoriteBookModel> bookList, OnItemClickListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteBookModel book = bookList.get(position);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.ivBookCover.setImageResource(book.getCoverImageRes());

        holder.btnBorrow.setOnClickListener(v -> {
            if (listener != null) listener.onBorrowClick(holder.getAdapterPosition());
        });

        holder.ivHeart.setOnClickListener(v -> {
            if (listener != null) listener.onFavoriteClick(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, btnBorrow;
        ImageView ivBookCover, ivHeart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvBookTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            btnBorrow = itemView.findViewById(R.id.btnBorrow);
            ivBookCover = itemView.findViewById(R.id.ivBookCover);
            ivHeart = itemView.findViewById(R.id.ivHeart);
        }
    }
}