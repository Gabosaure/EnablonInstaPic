package com.GabCorp.enablonpicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Contains the different resolution of the pictures
 */
public class ImageData {

    @SerializedName("standard_resolution")
    @Expose
    private Resolution standardResolution;

    @SerializedName("thumbnail")
    @Expose
    private Resolution thumbnail;

    @SerializedName("low_resolution")
    @Expose
    private Resolution low_resolution;

    public Resolution getStandardResolution() {
        return standardResolution;
    }

    public Resolution getThumbnail() {
        return thumbnail;
    }

    public Resolution getLow_resolution() {
        return low_resolution;
    }
}
