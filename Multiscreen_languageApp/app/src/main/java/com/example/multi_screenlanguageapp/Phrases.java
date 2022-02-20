package com.example.multi_screenlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    LinearLayout layout;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ////creating an ArrayList
        final ArrayList<Word> num = new ArrayList<Word>();
        num.add(new Word("namastey", "Hello",R.raw.phrase_one));
        num.add(new Word("Mera nam Shubham Kumar hai", "My name is Shubham Kumar",R.raw.phrase_two));
        num.add(new Word("aap kese hai", "How are you",R.raw.phrase_three));
        num.add(new Word("aapaka svaagat hain", "You are Welcome",R.raw.phrase_four));
        num.add(new Word("Aap se mike accha laga", "Nice to meet you",R.raw.phrase_five));
        num.add(new Word("Mujhe ab chalna cahiye", "I should go now",R.raw.phrase_six));
        num.add(new Word("Dhanyavaad", "Thank you",R.raw.phrase_seven));
        num.add(new Word("me School ja raha hu", "I am going to School",R.raw.phrase_eight));


        layout = new LinearLayout(this);
        layout = findViewById(R.id.linear1);


        WordAdapter itemsAdapter = new WordAdapter(this, num,R.color.c_Pha);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word =num.get(i);
                mediaPlayer= MediaPlayer.create(Phrases.this,word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}