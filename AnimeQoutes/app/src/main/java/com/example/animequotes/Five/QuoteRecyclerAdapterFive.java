package com.example.animequotes.Five;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterFive extends RecyclerView.Adapter<QuoteViewHolderFive>{
    Context context;
    List<QuoteResponseFive> list;
    CopyListenerFive listenerFive;

    public QuoteRecyclerAdapterFive(Context context, List<QuoteResponseFive> list, CopyListenerFive listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerFive = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderFive onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderFive(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderFive holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerFive.onCopyClickedFive(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

