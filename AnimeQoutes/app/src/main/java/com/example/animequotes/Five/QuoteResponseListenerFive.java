package com.example.animequotes.Five;

import java.util.List;

public interface QuoteResponseListenerFive {

    void didFetch(List<QuoteResponseFive> responses, String message);
    void didError(String message);

}
