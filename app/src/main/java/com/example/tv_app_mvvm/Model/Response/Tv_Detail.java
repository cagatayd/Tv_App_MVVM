package com.example.tv_app_mvvm.Model.Response;

public class Tv_Detail {


    public String original_language;
    public String original_name;
    public String name;
    public String overview;
    public double popularity;
    public Object backdrop_path;

    public Tv_Detail(String original_language, String original_name, String name, String overview, double popularity, Object backdrop_path) {
        this.original_language = original_language;
        this.original_name = original_name;
        this.name = name;
        this.overview = overview;
        this.popularity = popularity;
        this.backdrop_path = backdrop_path;
    }


    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Object getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(Object backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
