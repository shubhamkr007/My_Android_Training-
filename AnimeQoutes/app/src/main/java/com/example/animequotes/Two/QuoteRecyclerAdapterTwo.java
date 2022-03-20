package com.example.animequotes.Two;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterTwo extends RecyclerView.Adapter<QuoteViewHolderTwo>{
    Context context;
    List<QuoteResponseTwo> list;
    CopyListenerTwo listenerTwo;

    public QuoteRecyclerAdapterTwo(Context context, List<QuoteResponseTwo> list, CopyListenerTwo listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerTwo = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderTwo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderTwo(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderTwo holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerTwo.onCopyClickedTwo(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

