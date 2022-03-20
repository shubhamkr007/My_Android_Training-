package com.example.animequotes.Six;

import java.util.List;

public interface QuoteResponseListenerSix {

    void didFetch(List<QuoteResponseSix> responses, String message);
    void didError(String message);

}
