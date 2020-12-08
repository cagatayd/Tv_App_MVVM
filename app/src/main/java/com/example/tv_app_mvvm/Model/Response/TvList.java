package com.example.tv_app_mvvm.Model.Response;

import com.google.gson.annotations.SerializedName;

public class TvList {

    @SerializedName("name")
    public String title;

    @SerializedName("id")
    public int id;

    @SerializedName("poster_path")
    public String poster_path;

    public TvList(String title, int id, String poster_path) {
        this.title = title;
        this.id = id;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
