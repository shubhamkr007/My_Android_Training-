package com.example.animequotes.Four;

import java.util.List;

public interface QuoteResponseListenerFour {

    void didFetch(List<QuoteResponseFour> responses, String message);
    void didError(String message);

}
