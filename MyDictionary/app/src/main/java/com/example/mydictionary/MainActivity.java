package com.example.mydictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydictionary.Adapters.MeaningAdapter;
import com.example.mydictionary.Adapters.PhnoticsAdapter;
import com.example.mydictionary.Models.APIresponse;

public class MainActivity extends AppCompatActivity {
    SearchView search_View;
    TextView textView_word;
    RecyclerView recycler_phnotic;
    RecyclerView recycler_phnoticmeanings;
    ProgressDialog progressDialog;
    PhnoticsAdapter phnoticsAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search_View=findViewById(R.id.search);
        recycler_phnotic=findViewById(R.id.recycler_phnotic);
        recycler_phnoticmeanings=findViewById(R.id.recycler_phnoticmeanings);
        textView_word=findViewById(R.id.textView_word);
        progressDialog=new ProgressDialog(this);


        progressDialog.setTitle("Loading ... ");
        progressDialog.show();
        RequestManager requestManager=new RequestManager(MainActivity.this);
        requestManager.getWordMeaning(listener,"Hello");


        search_View.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching Response for "+query);
                progressDialog.show();
                RequestManager requestManager=new RequestManager(MainActivity.this);
                requestManager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    private onFetchDataListener listener=new onFetchDataListener() {
        @Override
        public void onFetchData(APIresponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private  void showData(APIresponse apiResponse) {
        textView_word.setText("Word : "+apiResponse.getWord());
        recycler_phnotic.setHasFixedSize(true);
        recycler_phnotic.setLayoutManager(new GridLayoutManager(this,1));
        phnoticsAdapter=new PhnoticsAdapter(this,apiResponse.getPhonetics());
        recycler_phnotic.setAdapter(phnoticsAdapter);
        recycler_phnoticmeanings.setHasFixedSize(true);
        recycler_phnoticmeanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter =new MeaningAdapter(this,apiResponse.getMeanings());
        recycler_phnoticmeanings.setAdapter(meaningAdapter);

    }
}