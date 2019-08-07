package com.GabCorp.enablonpicapp.models;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class InstaPic {

    private String imageURL;
    private String title;
    private String date;
    private int likes;
    private List<String> commentaries;

    public InstaPic(String image, String title, String date, int likes, List<String> commentaries) {
        this.imageURL = image;
        this.title = title;
        this.date = date;
        this.likes = likes;
        this.commentaries = commentaries;
    }
    public InstaPic(String image, String title) {
        Log.i(TAG, "InstaPic: new pic created");
        this.imageURL = image;
        this.title = title;
    }

    public void setImage(String image) {
        this.imageURL = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setCommentaries(List<String> commentaries) {
        this.commentaries = commentaries;
    }

    public String getImage() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public List<String> getCommentaries() {
        return commentaries;
    }


}
