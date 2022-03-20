package com.example.animequotes.Four;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManagerFour {

    Context context;
    Retrofit retrofit =new Retrofit.Builder().baseUrl("https://animechan.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManagerFour(Context context) {
        this.context = context;
    }

    public void getAllQuotesFour(QuoteResponseListenerFour listener){
        callQuotes callQuotesFour=retrofit.create(callQuotes.class);
        Call<List<QuoteResponseFour>> call= callQuotesFour.callQuotesFour();
        call.enqueue(new Callback<List<QuoteResponseFour>>() {
            @Override
            public void onResponse(Call<List<QuoteResponseFour>> call, Response<List<QuoteResponseFour>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request not Successful! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<List<QuoteResponseFour>> call, Throwable t) {
                listener.didError(t.getMessage());

            }
        });
    }

    private interface callQuotes{
        @GET("api/quotes/anime?title=Dragon Ball")
        Call<List<QuoteResponseFour>> callQuotesFour();
    }

}
