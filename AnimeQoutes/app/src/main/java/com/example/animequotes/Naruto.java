package com.example.animequotes;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.animequotes.One.CopyListenerOne;
import com.example.animequotes.One.QuoteRecyclerAdapterOne;
import com.example.animequotes.One.QuoteResponseListenerOne;
import com.example.animequotes.One.QuoteResponseOne;
import com.example.animequotes.One.RequestManagerOne;

import java.util.List;

public class Naruto extends AppCompatActivity implements CopyListenerOne {

    RecyclerView recyclerView;
    RequestManagerOne requestManager;
    QuoteRecyclerAdapterOne quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);

        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerOne(this);
        requestManager.getAllQuotesOne(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerOne listener=new QuoteResponseListenerOne() {
        @Override
        public void didFetch(List<QuoteResponseOne> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(Naruto.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseOne> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterOne(Naruto.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedOne(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(Naruto.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }


}
