package com.donhat.marketapp;

public class Item {
    private final int image;
    private final String title;
    private final String description;

    public Item(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
