package com.example.lms.model;

public class NotificationModel {
    private String title;
    private String message;
    private String time;
    private int backgroundColor;

    public NotificationModel(String title, String message, String time, int backgroundColor) {
        this.title = title;
        this.message = message;
        this.time = time;
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getTime() { return time; }
    public int getBackgroundColor() { return backgroundColor; }
}