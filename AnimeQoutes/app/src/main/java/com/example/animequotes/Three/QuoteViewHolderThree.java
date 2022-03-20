package com.example.animequotes.Three;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

public class QuoteViewHolderThree extends RecyclerView.ViewHolder {

    TextView textViewQuote, textViewCharacter, textViewAnime;
    Button buttonCopy;

    public QuoteViewHolderThree(@NonNull View itemView) {
        super(itemView);
        textViewAnime = itemView.findViewById(R.id.anime);
        textViewCharacter = itemView.findViewById(R.id.character);
        textViewQuote = itemView.findViewById(R.id.quote);
        buttonCopy = itemView.findViewById(R.id.copy);

    }
}
