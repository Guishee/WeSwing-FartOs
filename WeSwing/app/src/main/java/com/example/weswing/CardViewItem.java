package com.example.weswing;

public abstract class CardViewItem {

    public static final int VIEW_TYPE_TITLE = 0;
    public static final int VIEW_TYPE_TOGGLE_BUTTON = 1;
    public static final int VIEW_TYPE_ORGANIZER = 2;
    public static final int VIEW_TYPE_DESCRIPTION = 3;
    public static final int VIEW_TYPE_ATTENDEES = 4;
    public static final int VIEW_TYPE_IMAGES = 5;

    public abstract int getViewType();
}

