package com.example.animequotes;

public class QuoteResponse {
    String anime="";
    String character="";
    String quote="";

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
