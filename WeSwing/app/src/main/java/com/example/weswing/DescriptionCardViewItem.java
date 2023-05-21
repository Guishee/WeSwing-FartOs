package com.example.weswing;

public class DescriptionCardViewItem extends CardViewItem {

    private String description;

    public DescriptionCardViewItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_DESCRIPTION;
    }
}

