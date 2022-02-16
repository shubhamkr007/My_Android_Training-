package com.example.thebook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebook.Models.BookModel;
import com.example.thebook.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.viewholder>{

    ArrayList<BookModel> list;
    Context context;

    public BookAdapter(ArrayList<BookModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        BookModel model=list.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText(model.getBookName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.txt);

        }
    }

}
