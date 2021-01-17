package com.example.tv_app_mvvm.Local;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tv_app_mvvm.Model.Response.TvList;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
     void tvshowinsert(TvList tvList);

    @Query("select * from tvlists")
    LiveData<List<TvList>> gettvshowlists();

    @Delete
     void tvshowdelete(TvList tvList);


}
