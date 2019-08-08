package com.GabCorp.enablonpicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

/**
 * Contains data about a specific post
 */
public class Profil {

    @SerializedName("images")
    @Expose
    private ImageData imageData;

    @SerializedName("id")
    @Expose
    private String title;

    @SerializedName("created_time")
    @Expose
    private String date;

    @SerializedName("likes")
    private Likes likes;

    public ImageData getImageData() {
        return imageData;
    }

    public String getTitle() {
        return title;
    }

    public String getDate()  {
        // Converting the timestamp date into readable date
        /// Adding 000 as the return is in seconds and not milliseconds
        Timestamp ts = new Timestamp(Long.parseLong(date+"000"));
        return ""+ts;
    }

    public Likes getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "imageData=" + imageData +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", likes=" + likes +
                '}';
    }
}
