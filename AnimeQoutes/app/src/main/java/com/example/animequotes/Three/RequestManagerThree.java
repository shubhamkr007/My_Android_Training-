package com.example.animequotes.Three;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerThree {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerThree(Context context) {
        this.context = context;
    }

    public void getAllQuotesThree(QuoteResponseListenerThree listener){
        callQuotes callQuotesThree=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseThree>> call= callQuotesThree.callQuotesThree();
        call.enqueue(new Callback<List<QuoteResponseThree>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseThree>> call, Response<List<QuoteResponseThree>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseThree>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=Death Note")
        Call<List<QuoteResponseThree>> callQuotesThree();
    }

}
