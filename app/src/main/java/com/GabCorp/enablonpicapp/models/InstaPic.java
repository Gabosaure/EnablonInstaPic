package com.GabCorp.enablonpicapp.models;

/**
 * Specific object that will contains the data we want to display
 */

public class InstaPic {

    private String image;
    private String title;
    private String likes;
    private String date;

    public InstaPic(String title, String image, String likes, String date){
        this.title = title;
        this.image = image;
        this.likes = likes;
        this.date = date;
    }


    public String getImage() {
        return image;
    }

    public String getLikes() {
        return likes;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}
