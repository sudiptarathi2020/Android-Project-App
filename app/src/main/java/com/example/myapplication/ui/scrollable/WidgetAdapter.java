package com.example.myapplication.ui.scrollable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class WidgetAdapter extends RecyclerView.Adapter<WidgetAdapter.WidgetViewHolder>{
private List<WidgetItem> widgetItems;

    public WidgetAdapter(List<WidgetItem> widgetItems) {
        this.widgetItems = widgetItems;
    }

    @NonNull
    @Override
    public WidgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_widget, parent, false);
        return new WidgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WidgetViewHolder holder, int position) {
        WidgetItem currentItem = widgetItems.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textViewTitle.setText(currentItem.getTitle());
        holder.textViewPrice.setText(currentItem.getPrice());
        holder.textViewDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return widgetItems.size();
    }

    public static class WidgetViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewPrice;
        public TextView textViewDescription;

        public WidgetViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.widgetImage);
            textViewTitle = itemView.findViewById(R.id.widgetTitle);
            textViewPrice = itemView.findViewById(R.id.widgetPrice);
            textViewDescription = itemView.findViewById(R.id.widgetDescription);
        }
    }
}
