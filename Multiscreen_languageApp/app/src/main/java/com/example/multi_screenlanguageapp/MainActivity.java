package com.example.multi_screenlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1= new TextView(this);
        textView1=findViewById(R.id.t1);

        textView2= new TextView(this);
        textView2=findViewById(R.id.t2);

        textView3= new TextView(this);
        textView3=findViewById(R.id.t3);

        textView4= new TextView(this);
        textView4=findViewById(R.id.t4);

        ////for NUMBER
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,number.class);
                startActivity(intent);
            }
        });

        ////for COLOR
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,color.class);
                startActivity(intent);
            }
        });

        ////for RELATIONS
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Relations.class);
                startActivity(intent);
            }
        });

        ////for PHRASES
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Phrases.class);
                startActivity(intent);
            }
        });

    }
}