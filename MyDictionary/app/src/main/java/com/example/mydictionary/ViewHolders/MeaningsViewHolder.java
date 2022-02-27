package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_partsofspeech;
    public RecyclerView recycler_meanings;

    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_partsofspeech=itemView.findViewById(R.id.textView_partsofspeech);
        recycler_meanings=itemView.findViewById(R.id.recycler_meanings);
    }
}
