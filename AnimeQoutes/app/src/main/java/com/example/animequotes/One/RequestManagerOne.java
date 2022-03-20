package com.example.animequotes.One;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerOne {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerOne(Context context) {
        this.context = context;
    }

    public void getAllQuotesOne(QuoteResponseListenerOne listener){
        callQuotes callQuotesOne=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseOne>> call= callQuotesOne.callQuotesOne();
        call.enqueue(new Callback<List<QuoteResponseOne>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseOne>> call, Response<List<QuoteResponseOne>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseOne>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=naruto")
        Call<List<QuoteResponseOne>> callQuotesOne();
    }

}
