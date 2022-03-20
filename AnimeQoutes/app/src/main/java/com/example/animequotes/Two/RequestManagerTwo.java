package com.example.animequotes.Two;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerTwo {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerTwo(Context context) {
        this.context = context;
    }

    public void getAllQuotesTwo(QuoteResponseListenerTwo listener){
        callQuotes callQuotesTwo=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseTwo>> call= callQuotesTwo.callQuotesTwo();
        call.enqueue(new Callback<List<QuoteResponseTwo>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseTwo>> call, Response<List<QuoteResponseTwo>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseTwo>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=One Piece")
        Call<List<QuoteResponseTwo>> callQuotesTwo();
    }

}
