package com.example.lms;

public class Book {
    private final String title;
    private final String author;
    private final int coverRes;
    private final boolean available;

    public Book(String title, String author, int coverRes, boolean available) {
        this.title = title;
        this.author = author;
        this.coverRes = coverRes;
        this.available = available;
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public int getCoverRes() { return coverRes; }

    public boolean isAvailable() { return available; }
}