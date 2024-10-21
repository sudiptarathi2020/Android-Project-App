package com.example.myapplication.ui.scrollable;


public class WidgetItem {
    private int imageResource;
    private String title;
    private String price;
    private String description;

    public WidgetItem(int imageResource, String title, String price, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

