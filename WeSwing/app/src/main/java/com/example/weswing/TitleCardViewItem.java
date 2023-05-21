package com.example.weswing;

public class TitleCardViewItem extends CardViewItem {

    private String title;

    public TitleCardViewItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_TITLE;
    }
}

