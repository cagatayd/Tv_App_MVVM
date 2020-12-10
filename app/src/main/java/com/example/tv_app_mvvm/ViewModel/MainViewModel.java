package com.example.tv_app_mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tv_app_mvvm.Model.Response.BaseResponse;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.Repository.TvRepository;

public class MainViewModel extends AndroidViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<BaseResponse>getTopratedTvList(int pageIndex){
        return TvRepository.getInstance().getTopRatedTvList( pageIndex);
    }
    public MutableLiveData<BaseResponse>getPopularTvList(int pageIndex){
            return TvRepository.getInstance().getPopulartvList( pageIndex);
    }
    public MutableLiveData<BaseResponse>getOnairTvList(int pageIndex){
        return TvRepository.getInstance().getOnairtvList(pageIndex);
    }
    public MutableLiveData<BaseResponse>getOnAiringTodayTvList(int pageIndex){
        return TvRepository.getInstance().getOnairingtodaytvList( pageIndex);
    }
    public MutableLiveData<BaseResponse>getTvSearch(String query){
        return TvRepository.getInstance().getTvSearch(query);
    }
}
