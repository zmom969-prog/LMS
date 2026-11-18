package com.example.lms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;
import com.example.lms.model.BorrowHistoryModel;

import java.util.List;

public class BorrowHistoryAdapter extends RecyclerView.Adapter<BorrowHistoryAdapter.ViewHolder> {

    private List<BorrowHistoryModel> list;

    public BorrowHistoryAdapter(List<BorrowHistoryModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_borrow_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BorrowHistoryModel item = list.get(position);
        holder.tvDateHeader.setText(item.getDateHeader());
        holder.tvTime.setText(item.getTime());
        holder.tvBookTitle.setText(item.getBookTitle());
        holder.tvBorrowDuration.setText(item.getBorrowDuration());
        holder.ivBookCover.setImageResource(item.getBookCoverRes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDateHeader, tvTime, tvBookTitle, tvBorrowDuration;
        ImageView ivBookCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateHeader = itemView.findViewById(R.id.tvDateHeader);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvBookTitle = itemView.findViewById(R.id.tvBookTitle);
            tvBorrowDuration = itemView.findViewById(R.id.tvBorrowDuration);
            ivBookCover = itemView.findViewById(R.id.ivBookCover);
        }
    }
}