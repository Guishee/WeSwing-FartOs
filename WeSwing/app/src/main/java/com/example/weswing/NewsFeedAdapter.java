package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    private List<Notification> notifications;

    public NewsFeedAdapter(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView logoImageView;
        public TextView notificationTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.logoImageView);
            notificationTextView = itemView.findViewById(R.id.notificationTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.logoImageView.setImageResource(notification.getLogo());
        holder.notificationTextView.setText(notification.getText());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }
}
