package com.example.tv_app_mvvm.Local;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.tv_app_mvvm.Model.Response.TvList;

@Database(entities = {TvList.class},version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract MyDao myDao();



}
