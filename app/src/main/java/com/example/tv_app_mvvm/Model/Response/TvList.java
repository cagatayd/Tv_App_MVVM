package com.example.tv_app_mvvm.Model.Response;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tvlists")
public class TvList {

    @ColumnInfo (name = "tv_show_name")
    @SerializedName("name")
    public String title;


    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;

    @ColumnInfo(name = "tv_show_poster")
    @SerializedName("poster_path")
    public String poster_path;


//    public TvList(String title, int id, String poster_path) {
//        this.title = title;
//        this.id = id;
//        this.poster_path = poster_path;
//    }

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
