package com.example.tv_app_mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.Repository.TvRepository;

public class FavoriteViewModel extends AndroidViewModel {
    public FavoriteViewModel(@NonNull Application application) {
        super(application);
    }

    public void delete(TvList tvList)
    {
        TvRepository.getInstance().delete(tvList);
    }

}
