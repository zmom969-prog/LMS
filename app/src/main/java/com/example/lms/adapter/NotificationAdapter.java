package com.example.lms.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lms.R;
import com.example.lms.model.NotificationModel;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationModel> list;
    private OnItemRemoveListener removeListener;
    private OnCardClickListener cardClickListener;

    public interface OnItemRemoveListener {
        void onItemRemoved(int remainingCount);
    }

    public interface OnCardClickListener {
        void onCardClick(NotificationModel item, int position);
    }

    public NotificationAdapter(List<NotificationModel> list, OnItemRemoveListener removeListener, OnCardClickListener cardClickListener) {
        this.list = list;
        this.removeListener = removeListener;
        this.cardClickListener = cardClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel item = list.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvMessage.setText(item.getMessage());
        holder.tvTime.setText(item.getTime());
        holder.cardNotification.setCardBackgroundColor(item.getCardColor());

        // ចុចលើ Card ទាំងមូល
        holder.cardNotification.setOnClickListener(v -> {
            if (cardClickListener != null) {
                cardClickListener.onCardClick(item, holder.getAdapterPosition());
            }
        });

        // ចុចលើសញ្ញា X ដើម្បីលុប
        holder.btnClose.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                list.remove(currentPos);
                notifyItemRemoved(currentPos);
                if (removeListener != null) {
                    removeListener.onItemRemoved(list.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardNotification;
        TextView tvTitle, tvMessage, tvTime;
        ImageView btnClose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardNotification = itemView.findViewById(R.id.cardNotification);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
            btnClose = itemView.findViewById(R.id.btnClose);
        }
    }
}