package com.example.weswing;

public class Notification {
    private int logo;
    private String text;

    public Notification(int logo, String text) {
        this.logo = logo;
        this.text = text;
    }

    public int getLogo() {
        return logo;
    }

    public String getText() {
        return text;
    }
}
