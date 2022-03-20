package com.example.animequotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.animequotes.Six.CopyListenerSix;
import com.example.animequotes.Six.QuoteRecyclerAdapterSix;
import com.example.animequotes.Six.QuoteResponseListenerSix;
import com.example.animequotes.Six.QuoteResponseSix;
import com.example.animequotes.Six.RequestManagerSix;

import java.util.List;

public class MyHero extends AppCompatActivity implements CopyListenerSix {

    RecyclerView recyclerView;
    RequestManagerSix requestManager;
    QuoteRecyclerAdapterSix quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);


        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerSix(this);
        requestManager.getAllQuotesSix(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerSix listener=new QuoteResponseListenerSix() {
        @Override
        public void didFetch(List<QuoteResponseSix> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(MyHero.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseSix> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterSix(MyHero.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedSix(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(MyHero.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }


}