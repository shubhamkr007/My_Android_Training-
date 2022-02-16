package com.example.thebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.thebook.Adapter.BookAdapter;
import com.example.thebook.Models.BookModel;
import com.example.thebook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<BookModel> list = new ArrayList<>();
        list.add(new BookModel(R.drawable.book, "Book1"));
        list.add(new BookModel(R.drawable.book, "Book2"));
        list.add(new BookModel(R.drawable.book, "Book3"));
        list.add(new BookModel(R.drawable.book, "Book4"));
        list.add(new BookModel(R.drawable.book, "Book5"));

        list.add(new BookModel(R.drawable.book, "Book1"));
        list.add(new BookModel(R.drawable.book, "Book2"));
        list.add(new BookModel(R.drawable.book, "Book3"));
        list.add(new BookModel(R.drawable.book, "Book4"));
        list.add(new BookModel(R.drawable.book, "Book5"));

        list.add(new BookModel(R.drawable.book, "Book1"));
        list.add(new BookModel(R.drawable.book, "Book2"));
        list.add(new BookModel(R.drawable.book, "Book3"));
        list.add(new BookModel(R.drawable.book, "Book4"));
        list.add(new BookModel(R.drawable.book, "Book5"));

        BookAdapter adapter = new BookAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);

//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        binding.recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
    }
}