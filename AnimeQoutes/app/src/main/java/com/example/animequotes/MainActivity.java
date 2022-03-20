package com.example.animequotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView card1,card2,card3,card4,card5,card6,random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random=findViewById(R.id.random);
        card1=findViewById(R.id.c1);
        card2=findViewById(R.id.c2);
        card3=findViewById(R.id.c3);
        card4=findViewById(R.id.c4);
        card5=findViewById(R.id.c5);
        card6=findViewById(R.id.c6);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        random.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()){
            case R.id.random:
                intent =new Intent(this,TenRandomQuotes.class);
                startActivity(intent);
                return;
            case R.id.c1 :
                intent =new Intent(this,Naruto.class);
                startActivity(intent);
                return;
            case R.id.c2 :
                intent =new Intent(this,OnePiece.class);
                startActivity(intent);
                return;
            case R.id.c3 :
                intent =new Intent(this,DragonBall.class);
                startActivity(intent);
                return;
            case R.id.c4 :
                intent =new Intent(this,FullMetal.class);
                startActivity(intent);
                return;
            case R.id.c5 :
                intent =new Intent(this,DeathNote.class);
                startActivity(intent);
                return;
            case R.id.c6 :
                intent =new Intent(this,MyHero.class);
                startActivity(intent);
                return;
        }
    }
}