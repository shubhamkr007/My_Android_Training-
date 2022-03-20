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

import com.example.animequotes.Four.CopyListenerFour;
import com.example.animequotes.Four.QuoteRecyclerAdapterFour;
import com.example.animequotes.Four.QuoteResponseListenerFour;
import com.example.animequotes.Four.QuoteResponseFour;
import com.example.animequotes.Four.RequestManagerFour;

import java.util.List;

public class DragonBall extends AppCompatActivity implements CopyListenerFour {


    RecyclerView recyclerView;
    RequestManagerFour requestManager;
    QuoteRecyclerAdapterFour quoteRecyclerAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_random_quotes);

        recyclerView=findViewById(R.id.recyclerView);
        requestManager=new RequestManagerFour(this);
        requestManager.getAllQuotesFour(listener);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Loading ...");
        dialog.show();

    }

    private final QuoteResponseListenerFour listener=new QuoteResponseListenerFour() {
        @Override
        public void didFetch(List<QuoteResponseFour> responses, String message) {
            showData(responses);
            dialog.dismiss();
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(DragonBall.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<QuoteResponseFour> responses) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        quoteRecyclerAdapter=new QuoteRecyclerAdapterFour(DragonBall.this,responses,this);
        recyclerView.setAdapter(quoteRecyclerAdapter);

    }
    public void onCopyClickedFour(String text) {
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData data=ClipData.newPlainText("Copies Data",text);
        clipboardManager.setPrimaryClip(data);
        Toast.makeText(DragonBall.this, "Copied To Clipboard ", Toast.LENGTH_SHORT).show();
    }


}