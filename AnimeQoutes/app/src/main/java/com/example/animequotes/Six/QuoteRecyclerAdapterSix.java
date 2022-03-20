package com.example.animequotes.Six;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterSix extends RecyclerView.Adapter<QuoteViewHolderSix>{
    Context context;
    List<QuoteResponseSix> list;
    CopyListenerSix listenerSix;

    public QuoteRecyclerAdapterSix(Context context, List<QuoteResponseSix> list, CopyListenerSix listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerSix = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderSix onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderSix(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderSix holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerSix.onCopyClickedSix(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

