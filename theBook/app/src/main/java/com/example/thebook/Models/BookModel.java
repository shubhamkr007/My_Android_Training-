package com.example.thebook.Models;

public class BookModel {
    int image;
    String BookName;

    public BookModel(int image, String bookName) {
        this.image = image;
        BookName = bookName;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }
}
