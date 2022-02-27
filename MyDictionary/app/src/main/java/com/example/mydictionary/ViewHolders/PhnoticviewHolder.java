package com.example.mydictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;

public class PhnoticviewHolder extends RecyclerView.ViewHolder {

    public TextView textView_phnotic;
    public ImageButton imageButton_audio;

    public PhnoticviewHolder(@NonNull View itemView) {
        super(itemView);

        textView_phnotic=itemView.findViewById(R.id.textView_phnotic);
        imageButton_audio=itemView.findViewById(R.id.imageButton_audio);

    }
}
