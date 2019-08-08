package com.GabCorp.enablonpicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Contains the number of likes
 */
public class Likes {

    @SerializedName("count")
    @Expose
    private String count;

    public String getCount() {
        return count;
    }
}
