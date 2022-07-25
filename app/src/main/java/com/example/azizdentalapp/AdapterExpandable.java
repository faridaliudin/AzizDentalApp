package com.example.azizdentalapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class AdapterExpandable extends RecyclerView.Adapter<AdapterExpandable.ViewHolder> {

    private ArrayList<ExpandableItem> eItems;
    private Context context;

    public AdapterExpandable(ArrayList<ExpandableItem> eItems, Context context) {
        this.eItems = eItems;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterExpandable.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExpandable.ViewHolder holder, final int position) {

        final ExpandableItem item = eItems.get(position);
        holder.imageView.setImageResource(item.getImageResourse());
        holder.titleTextView.setText(item.getTitle());
        holder.descTextView.setText(item.getDesc());
        holder.descTextView.setOnStateChangeListener(new ExpandableTextView.OnStateChangeListener() {
            @Override
            public void onStateChange(boolean isShrink) {
                ExpandableItem contentItem = eItems.get(position);
                contentItem.setShrink(isShrink);
                eItems.set(position, contentItem);
            }
        });
        holder.descTextView.setText(item.getDesc());
        holder.descTextView.resetState(item.isShrink());
    }

    @Override
    public int getItemCount() {
        return eItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ExpandableTextView descTextView;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            descTextView = itemView.findViewById(R.id.descTextView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
