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

import com.example.animequotes.Five.CopyListenerFive;
import com.example.animequotes.Five.QuoteRecyclerAdapterFive;
import com.example.animequotes.Five.QuoteResponseFive;
import com.example.animequotes.Five.QuoteResponseListenerFive;
import com.example.animequotes.Five.RequestManagerFive;

import java.util.List;

public class FullMetal extends AppCompatActivity implements CopyListenerFive {


    RecyclerView recyclerView;
    RequestManagerFive requestManager;
    QuoteRecyclerAdapterFive quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);

        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerFive(this);
        requestManager.getAllQuotesFive(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerFive listener=new QuoteResponseListenerFive() {
        @Override
        public void didFetch(List<QuoteResponseFive> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(FullMetal.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseFive> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterFive(FullMetal.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedFive(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(FullMetal.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }

}