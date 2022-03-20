package com.example.animequotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteViewHolder>{
    Context context;
    List<QuoteResponse> list;
    CopyListener listener;

    public QuoteRecyclerAdapter(Context context, List<QuoteResponse> list, CopyListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolder(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCopyClicked(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

