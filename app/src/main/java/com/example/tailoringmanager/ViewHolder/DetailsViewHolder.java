package com.example.tailoringmanager.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tailoringmanager.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName, tvPrice, tvDescription;
    public ImageView ivImage;

    public DetailsViewHolder(@NonNull View itemView) {
        super(itemView);

        ivImage=itemView.findViewById(R.id.ivImage);
        tvName=itemView.findViewById(R.id.tvName);
        tvPrice=itemView.findViewById(R.id.tvPrice);
    }
}
