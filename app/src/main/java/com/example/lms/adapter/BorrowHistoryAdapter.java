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
        holder.tvHeaderDate.setText(item.getHeaderDate());
        holder.tvTime.setText(item.getTime());
        holder.imgBookCover.setImageResource(item.getBookCoverResId());
        holder.tvBookTitle.setText(item.getBookTitle());
        holder.tvDateRange.setText(item.getDateRange());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeaderDate, tvTime, tvBookTitle, tvDateRange;
        ImageView imgBookCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeaderDate = itemView.findViewById(R.id.tvHeaderDate);
            tvTime = itemView.findViewById(R.id.tvTime);
            imgBookCover = itemView.findViewById(R.id.imgBookCover);
            tvBookTitle = itemView.findViewById(R.id.tvBookTitle);
            tvDateRange = itemView.findViewById(R.id.tvDateRange);
        }
    }
}