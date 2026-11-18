package com.example.lms.model;


public class FavoriteBookModel {
    private String title;
    private String author;
    private int coverImageRes;

    public FavoriteBookModel(String title, String author, int coverImageRes) {
        this.title = title;
        this.author = author;
        this.coverImageRes = coverImageRes;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getCoverImageRes() { return coverImageRes; }
}