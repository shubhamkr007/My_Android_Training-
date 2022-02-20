package com.example.multi_screenlanguageapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class color extends AppCompatActivity {
    LinearLayout layout;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ArrayList<Word> num=new ArrayList<Word>();
        num.add(new Word("Laal","Red",R.drawable.color_red,R.raw.color_red));
        num.add(new  Word("Hara","Green",R.drawable.color_green,R.raw.color_green));
        num.add(new  Word("Pila","Yellow",R.drawable.color_mustard_yellow,R.raw.color_yellow));
//        num.add(new  Word("Neela","Blue",R.drawable.bl));
        num.add(new  Word("Kaala","Black",R.drawable.color_black,R.raw.color_black));
        num.add(new  Word("Safed","White",R.drawable.color_white,R.raw.color_white));
        num.add(new  Word("Bhura","Brown",R.drawable.color_brown,R.raw.color_bown));
//        num.add(new  Word("Narangi","Orange"));
//        num.add(new  Word("Baingani","Purple"));
//        num.add(new  Word("Gulabi","Pink"));


        layout=new LinearLayout(this);
        layout=findViewById(R.id.linear1);


        WordAdapter itemsAdapter = new WordAdapter(this,num,R.color.c_Col);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word =num.get(i);
                mediaPlayer= MediaPlayer.create(color.this,word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}