package com.example.animequotes.Three;

import java.util.List;

public interface QuoteResponseListenerThree {

    void didFetch(List<QuoteResponseThree> responses, String message);
    void didError(String message);

}
