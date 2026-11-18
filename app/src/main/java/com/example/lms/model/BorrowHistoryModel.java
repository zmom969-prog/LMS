package com.example.lms.model;

public class BorrowHistoryModel {
    private String dateHeader;
    private String time;
    private String bookTitle;
    private String borrowDuration;
    private int bookCoverRes;

    public BorrowHistoryModel(String dateHeader, String time, String bookTitle, String borrowDuration, int bookCoverRes) {
        this.dateHeader = dateHeader;
        this.time = time;
        this.bookTitle = bookTitle;
        this.borrowDuration = borrowDuration;
        this.bookCoverRes = bookCoverRes;
    }

    public String getDateHeader() { return dateHeader; }
    public String getTime() { return time; }
    public String getBookTitle() { return bookTitle; }
    public String getBorrowDuration() { return borrowDuration; }
    public int getBookCoverRes() { return bookCoverRes; }
}