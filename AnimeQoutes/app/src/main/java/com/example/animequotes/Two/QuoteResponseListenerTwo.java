package com.example.animequotes.Two;

import java.util.List;

public interface QuoteResponseListenerTwo {

    void didFetch(List<QuoteResponseTwo> responses, String message);
    void didError(String message);

}
