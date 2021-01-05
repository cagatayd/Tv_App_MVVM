package com.example.tv_app_mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.Repository.TvRepository;

public class DetailViewModel extends AndroidViewModel {
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Tv_Detail>getTvDetail(int tv_id){
        return TvRepository.getInstance().getTvdetail(tv_id);
    }


    public  void insert(TvList tvList) {
        TvRepository.getInstance().insert(tvList);

    }
}
