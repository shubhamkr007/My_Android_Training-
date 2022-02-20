package com.example.multi_screenlanguageapp;

import android.media.Image;

public class Word {

    private String Hindi;
    private String Default;
    private int imageResourceId = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private  int maudioResourceId;
    public Word(String hindi, String aDefault,int audio) {
        Hindi = hindi;
        Default = aDefault;
        maudioResourceId=audio;
    }

    public Word(String hindi, String aDefault, int imageResourceId,int audio ) {
        Hindi = hindi;
        Default = aDefault;
        this.imageResourceId = imageResourceId;
        maudioResourceId=audio;
    }

    public String getHindi() {
        return Hindi;
    }

    public String getDefault() {
        return Default;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE;
    }

    public int getAudioResourceId(){
        return maudioResourceId;
    }
}

