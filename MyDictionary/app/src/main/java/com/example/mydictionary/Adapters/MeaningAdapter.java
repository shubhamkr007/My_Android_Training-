package com.example.mydictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Meanings;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.MeaningsViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {

    private Context context;
    protected List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.phnotiic_meaning_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {

        holder.textView_partsofspeech.setText("Parts Of Speech "+meaningsList.get(position).getPartOfSpeech());
        holder.recycler_meanings.setHasFixedSize(true);
        holder.recycler_meanings.setLayoutManager(new GridLayoutManager(context,1));
        DefinationAdapter adapter=new DefinationAdapter(context,meaningsList.get(position).getDefinitions());
        holder.recycler_meanings.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
