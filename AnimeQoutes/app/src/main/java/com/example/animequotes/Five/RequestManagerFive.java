package com.example.animequotes.Five;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerFive {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerFive(Context context) {
        this.context = context;
    }

    public void getAllQuotesFive(QuoteResponseListenerFive listener){
        callQuotes callQuotesFive=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseFive>> call= callQuotesFive.callQuotesFive();
        call.enqueue(new Callback<List<QuoteResponseFive>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseFive>> call, Response<List<QuoteResponseFive>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseFive>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=Fullmetal Alchemist")
        Call<List<QuoteResponseFive>> callQuotesFive();
    }

}
