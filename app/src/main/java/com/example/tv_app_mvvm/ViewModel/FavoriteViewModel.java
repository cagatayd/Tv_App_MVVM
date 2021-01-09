package com.example.tv_app_mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.Repository.TvRepository;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {
    public FavoriteViewModel(@NonNull Application application) {
        super(application);
    }

    public void delete(TvList tvList)
    {
        TvRepository.getInstance().delete(tvList);
    }

    public LiveData<List<TvList>> getTvList(){
        return TvRepository.getInstance().getTvList();
    }

}
