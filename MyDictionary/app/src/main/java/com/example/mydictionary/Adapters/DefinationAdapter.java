package com.example.mydictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.Models.Defination;
import com.example.mydictionary.R;
import com.example.mydictionary.ViewHolders.DefinationViewHolder;

import java.util.List;

public class DefinationAdapter extends RecyclerView.Adapter<DefinationViewHolder> {

    private Context context;
    private List<Defination> definationList;

    public DefinationAdapter(Context context, List<Defination> definationList) {
        this.context = context;
        this.definationList = definationList;
    }

    @NonNull
    @Override
    public DefinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinationViewHolder(LayoutInflater.from(context).inflate(R.layout.defination_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinationViewHolder holder, int position) {
        holder.textView_defination.setText("Definition : "+definationList.get(position).getDefinition());
        holder.textView_example.setText("Example : "+definationList.get(position).getExample());
        StringBuilder synonyms =new StringBuilder();
        StringBuilder antonyms =new StringBuilder();

        synonyms.append(definationList.get(position).getSynonyms());
        antonyms.append(definationList.get(position).getAntonyms());

        holder.textView_synonyms.setText("Synonyms : "+synonyms);
        holder.textView_antonyms.setText("Antonyms : "+antonyms);

        holder.textView_synonyms.setSelected(true);
        holder.textView_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definationList.size();
    }
}
