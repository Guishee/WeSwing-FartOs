package com.example.weswing;

public class AttendeesCardViewItem extends CardViewItem {

    private String attendeesCount;

    public AttendeesCardViewItem(String attendeesCount) {
        this.attendeesCount = attendeesCount;
    }

    public String getAttendeesCount() {
        return attendeesCount;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_ATTENDEES;
    }
}
