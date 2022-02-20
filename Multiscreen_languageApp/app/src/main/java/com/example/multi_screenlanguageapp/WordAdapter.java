package com.example.multi_screenlanguageapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private  int colorresid;

    public WordAdapter(Activity context, ArrayList<Word> androidFlavors, int mcolorresid) {
        super(context, 0, androidFlavors);
        colorresid=mcolorresid;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView;
        listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView nameTextView1 = (TextView) listItemView.findViewById(R.id.textView7);
        nameTextView1.setText(currentWord.getHindi());
        TextView numberTextView2 = (TextView) listItemView.findViewById(R.id.textView8);
        numberTextView2.setText(currentWord.getDefault());

        ImageView imageView=(ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer=listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),colorresid);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
