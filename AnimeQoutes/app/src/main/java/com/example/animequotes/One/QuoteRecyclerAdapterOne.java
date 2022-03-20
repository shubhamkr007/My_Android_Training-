package com.example.animequotes.One;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterOne extends RecyclerView.Adapter<QuoteViewHolderOne>{
    Context context;
    List<QuoteResponseOne> list;
    CopyListenerOne listenerOne;

    public QuoteRecyclerAdapterOne(Context context, List<QuoteResponseOne> list, CopyListenerOne listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerOne = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderOne onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderOne(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderOne holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerOne.onCopyClickedOne(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

