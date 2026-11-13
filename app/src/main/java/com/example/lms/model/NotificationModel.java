package com.example.lms.model;

public class NotificationModel {
    private String title;
    private String message;
    private String time;
    private int cardColor; // កូដពណ៌សម្រាប់ Card នីមួយៗ

    public NotificationModel(String title, String message, String time, int cardColor) {
        this.title = title;
        this.message = message;
        this.time = time;
        this.cardColor = cardColor;
    }

    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getTime() { return time; }
    public int getCardColor() { return cardColor; }
}