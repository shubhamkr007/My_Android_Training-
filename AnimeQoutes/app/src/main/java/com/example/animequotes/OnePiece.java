package com.example.animequotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.animequotes.Two.CopyListenerTwo;
import com.example.animequotes.Two.QuoteRecyclerAdapterTwo;
import com.example.animequotes.Two.QuoteResponseListenerTwo;
import com.example.animequotes.Two.QuoteResponseTwo;
import com.example.animequotes.Two.RequestManagerTwo;

import java.util.List;

public class OnePiece extends AppCompatActivity implements CopyListenerTwo {

    RecyclerView recyclerView;
    RequestManagerTwo requestManager;
    QuoteRecyclerAdapterTwo quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);



        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerTwo(this);
        requestManager.getAllQuotesTwo(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerTwo listener=new QuoteResponseListenerTwo() {
        @Override
        public void didFetch(List<QuoteResponseTwo> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(OnePiece.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseTwo> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterTwo(OnePiece.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedTwo(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(OnePiece.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }

}