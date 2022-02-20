package com.example.multi_screenlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Relations extends AppCompatActivity {

    LinearLayout layout;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relations);


        ////creating an ArrayList
        final ArrayList<Word> num=new ArrayList<Word>();
        num.add(new Word("ma","Mother",R.drawable.family_mother,R.raw.relation_mother));
        num.add(new  Word("pitā","Father",R.drawable.family_father,R.raw.relation_father));
        num.add(new  Word("pati","Husband",R.drawable.family_father,R.raw.relation_husband));
        num.add(new  Word("patnī","Wife",R.drawable.family_mother,R.raw.relation_wife));
        num.add(new  Word("beṭā","Son",R.drawable.family_son,R.raw.relation_son));
        num.add(new  Word("beṭī","Daughter",R.drawable.family_daughter,R.raw.relation_daughter));
        num.add(new  Word("nānī","Grandma",R.drawable.family_grandmother,R.raw.relation_grandma));
        num.add(new  Word("dādī","Grandmother",R.drawable.family_grandmother,R.raw.relation_grandmother));
        num.add(new  Word("nānā","Grandpa",R.drawable.family_grandfather,R.raw.relation_grandpa));
        num.add(new  Word("dādā","Grandfather",R.drawable.family_grandfather,R.raw.relation_grandfather));
        num.add(new  Word("chāchā","Uncle",R.drawable.family_father,R.raw.relation_uncle));
        num.add(new  Word("chāchī","Aunt",R.drawable.family_mother,R.raw.relation_aunt));

        layout=new LinearLayout(this);
        layout=findViewById(R.id.linear1);


        WordAdapter itemsAdapter = new WordAdapter(this,num,R.color.c_Rel);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word =num.get(i);
                mediaPlayer= MediaPlayer.create(Relations.this,word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}