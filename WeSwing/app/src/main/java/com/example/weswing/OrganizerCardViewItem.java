package com.example.weswing;

public class OrganizerCardViewItem extends CardViewItem {

    private int photo;
    private String name;

    public OrganizerCardViewItem(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_ORGANIZER;
    }
}

