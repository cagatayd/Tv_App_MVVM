package com.example.tv_app_mvvm.Model.Request;

public class GetTvDetail {

    public int tv_id;

    public GetTvDetail(int tv_id) {
        this.tv_id = tv_id;
    }

    public int getTv_id() {
        return tv_id;
    }

    public void setTv_id(int tv_id) {
        this.tv_id = tv_id;
    }
}
