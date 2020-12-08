package com.example.tv_app_mvvm.Model.Request;

public class TvSearch {

    public String query;

    public TvSearch(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
