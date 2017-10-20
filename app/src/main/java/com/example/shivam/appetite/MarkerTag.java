package com.example.shivam.appetite;

/**
 * Created by shivam on 11/10/17.
 */


public class MarkerTag {
    String name;
    String state;
    String category;

    public MarkerTag(String name, String state, String category) {
        this.name = name;
        this.state = state;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getCategory() {
        return category;
    }
}