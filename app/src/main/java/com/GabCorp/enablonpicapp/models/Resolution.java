package com.GabCorp.enablonpicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Contains the URL of the image corresponding the the resolution chosen
 */
public class Resolution {

    @SerializedName("url")
    @Expose
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

}
