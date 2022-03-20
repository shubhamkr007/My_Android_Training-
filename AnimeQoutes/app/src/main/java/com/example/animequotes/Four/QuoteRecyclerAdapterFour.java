package com.example.animequotes.Four;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterFour extends RecyclerView.Adapter<QuoteViewHolderFour>{
    Context context;
    List<QuoteResponseFour> list;
    CopyListenerFour listenerFour;

    public QuoteRecyclerAdapterFour(Context context, List<QuoteResponseFour> list, CopyListenerFour listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerFour = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderFour onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderFour(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderFour holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerFour.onCopyClickedFour(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

