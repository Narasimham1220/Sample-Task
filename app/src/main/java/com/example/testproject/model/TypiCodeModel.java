package com.example.testproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TypiCodeModel implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String imageurl;

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
