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
    public MutableLiveData<BaseResponse>getTopratedTvList(){
        return TvRepository.getInstance().getTopRatedTvList();
    }
    public MutableLiveData<BaseResponse>getPopularTvList(){
        return TvRepository.getInstance().getPopulartvList();
    }
    public MutableLiveData<BaseResponse>getOnairTvList(){
        return TvRepository.getInstance().getOnairtvList();
    }
    public MutableLiveData<BaseResponse>getOnAiringTodayTvList(){
        return TvRepository.getInstance().getOnairingtodaytvList();
    }
    public MutableLiveData<BaseResponse>getTvSearch(String query){
        return TvRepository.getInstance().getTvSearch(query);
    }
}
