package com.GabCorp.enablonpicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Contains the global data (several Instagram posts)
 * Retrieves a list of posts
 */
public class ApiData {

    @SerializedName("data")
    @Expose
    private List<Profil> data;

    public List<Profil> getData() {
        return data;
    }
}
