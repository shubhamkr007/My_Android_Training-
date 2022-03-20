package com.example.animequotes.Three;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animequotes.R;

import java.util.List;
import java.util.Objects;

public class QuoteRecyclerAdapterThree extends RecyclerView.Adapter<QuoteViewHolderThree>{
    Context context;
    List<QuoteResponseThree> list;
    CopyListenerThree listenerThree;

    public QuoteRecyclerAdapterThree(Context context, List<QuoteResponseThree> list, CopyListenerThree listenerOne) {
        this.context = context;
        this.list = list;
        this.listenerThree = listenerOne;
    }

    @NonNull
    @Override
    public QuoteViewHolderThree onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuoteViewHolderThree(LayoutInflater.from(context).inflate(R.layout.list_quote,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolderThree holder, int position) {
        holder.textViewAnime.setText(list.get(position).getAnime());
        holder.textViewCharacter.setText(list.get(position).getCharacter());
        holder.textViewQuote.setText(list.get(position).getQuote());
        holder.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerThree.onCopyClickedThree(list.get(Objects.requireNonNull(holder).getAdapterPosition()).getQuote());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

