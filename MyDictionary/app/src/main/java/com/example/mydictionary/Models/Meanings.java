package com.example.mydictionary.Models;

import java.util.List;

public class Meanings {
    String partOfSpeech="";
    List<Defination> definitions=null;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Defination> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Defination> definitions) {
        this.definitions = definitions;
    }
}
