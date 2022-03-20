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

import com.example.animequotes.Three.CopyListenerThree;
import com.example.animequotes.Three.QuoteRecyclerAdapterThree;
import com.example.animequotes.Three.QuoteResponseListenerThree;
import com.example.animequotes.Three.QuoteResponseThree;
import com.example.animequotes.Three.RequestManagerThree;

import java.util.List;

public class DeathNote extends AppCompatActivity implements CopyListenerThree {

    RecyclerView recyclerView;
    RequestManagerThree requestManager;
    QuoteRecyclerAdapterThree quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);

        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerThree(this);
        requestManager.getAllQuotesThree(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerThree listener=new QuoteResponseListenerThree() {
        @Override
        public void didFetch(List<QuoteResponseThree> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(DeathNote.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseThree> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterThree(DeathNote.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedThree(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(DeathNote.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }

}