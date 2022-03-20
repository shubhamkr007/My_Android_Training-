package com.example.animequotes.One;

import java.util.List;

public interface QuoteResponseListenerOne {

    void didFetch(List<QuoteResponseOne> responses, String message);
    void didError(String message);

}
