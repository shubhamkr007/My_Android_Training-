package com.example.animequotes.Six;

import android.content.Context;
import android.widget.Toast;

import com.example.animequotes.Six.QuoteResponseListenerSix;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerSix {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerSix(Context context) {
        this.context = context;
    }

    public void getAllQuotesSix(QuoteResponseListenerSix listener){
        callQuotes callQuotesSix=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseSix>> call= callQuotesSix.callQuotesSix();
        call.enqueue(new Callback<List<QuoteResponseSix>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseSix>> call, Response<List<QuoteResponseSix>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseSix>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=Boku no Hero Academia")
        Call<List<QuoteResponseSix>> callQuotesSix();
    }

}
