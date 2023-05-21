package com.example.weswing;

public class ImagesCardViewItem extends CardViewItem {

    private String imagesText;

    public ImagesCardViewItem(String imagesText) {
        this.imagesText = imagesText;
    }

    public String getImagesText() {
        return imagesText;
    }

    @Override
    public int getViewType() {
        return VIEW_TYPE_IMAGES;
    }
}
