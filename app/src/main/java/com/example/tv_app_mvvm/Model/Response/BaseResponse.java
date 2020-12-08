package com.example.tv_app_mvvm.Model.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {


    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<TvList>  results;

    public BaseResponse(int page, List<TvList> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TvList> getResults() {
        return results;
    }

    public void setResults(List<TvList> results) {
        this.results = results;
    }
}
