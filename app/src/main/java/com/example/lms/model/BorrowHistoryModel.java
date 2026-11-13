package com.example.lms.model;

public class BorrowHistoryModel {
    private String headerDate;
    private String time;
    private int bookCoverResId;
    private String bookTitle;
    private String dateRange;

    public BorrowHistoryModel(String headerDate, String time, int bookCoverResId, String bookTitle, String dateRange) {
        this.headerDate = headerDate;
        this.time = time;
        this.bookCoverResId = bookCoverResId;
        this.bookTitle = bookTitle;
        this.dateRange = dateRange;
    }

    public String getHeaderDate() { return headerDate; }
    public String getTime() { return time; }
    public int getBookCoverResId() { return bookCoverResId; }
    public String getBookTitle() { return bookTitle; }
    public String getDateRange() { return dateRange; }
}