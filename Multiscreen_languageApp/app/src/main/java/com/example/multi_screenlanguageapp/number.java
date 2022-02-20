package com.example.multi_screenlanguageapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class number extends AppCompatActivity {
    LinearLayout layout;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ////creating an ArrayList
        final ArrayList<Word> num=new ArrayList<Word>();
        num.add(new Word("ek","One",R.drawable.number_one,R.raw.number_one));
        num.add(new  Word("do","Two",R.drawable.number_two,R.raw.number_two));
        num.add(new  Word("tīn","Three",R.drawable.number_three,R.raw.number_three));
        num.add(new  Word("chār","Four",R.drawable.number_four,R.raw.number_four));
        num.add(new  Word("pāṅc","Five",R.drawable.number_five,R.raw.number_five));
        num.add(new  Word("chaḥ","Six",R.drawable.number_six,R.raw.number_six));
        num.add(new  Word("sāt","Seven",R.drawable.number_seven,R.raw.number_seven));
        num.add(new  Word("āṭh","Eight",R.drawable.number_eight,R.raw.number_eight));
        num.add(new  Word("nau","Nine",R.drawable.number_nine,R.raw.number_nine));
        num.add(new  Word("das","Ten",R.drawable.number_ten,R.raw.number_ten));
//        num.add(new  Word("gyārah","Eleven"));
//        num.add(new  Word("bārah","Twelve"));
//        num.add(new  Word("tērah","Thirteen"));
//        num.add(new  Word("caudah","Fourteen"));
//        num.add(new  Word("paṃdrah","Fifteen"));
//        num.add(new  Word("solaha","Sixteen"));
//        num.add(new  Word("satrah","Seventeen"));

        layout=new LinearLayout(this);
        layout=findViewById(R.id.linear1);


        WordAdapter itemsAdapter = new WordAdapter(this,num,R.color.c_Num);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word =num.get(i);
                mediaPlayer=MediaPlayer.create(number.this,word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
        }
    }