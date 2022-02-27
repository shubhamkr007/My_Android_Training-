package com.example.mydictionary.Models;

import java.util.List;

public class APIresponse {
    String word="";
    List<Phonatic> phonetics =null;
    List<Meanings> meanings=null;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonatic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonatic> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}
