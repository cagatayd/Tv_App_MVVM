package com.example.tv_app_mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.tv_app_mvvm.Adapter.TvFavoriteAdapter;
import com.example.tv_app_mvvm.Listener.OnTvItemDeleteClickListener;
import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.ViewModel.FavoriteViewModel;
import com.example.tv_app_mvvm.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class FavoriteActivity extends AppCompatActivity implements OnTvItemDeleteClickListener {


    GridLayoutManager gridLayoutManager;
    TvFavoriteAdapter tvFavoriteAdapter;
    private RecyclerView recyclerViewq;



    FavoriteViewModel favoriteViewModel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
               favoriteViewModel = new ViewModelProvider(getViewModelStore(),
                       new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(FavoriteViewModel.class);
        favoriteViewModel.getTvList().observe(this, new Observer<List<TvList>>() {
            @Override
            public void onChanged(List<TvList> tvLists) {
                loadTvList(tvLists);
            }
        });

        init();
    }

    public void init()
    {
        recyclerViewq=findViewById(R.id.recyclerViewfavorite);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewq.setItemAnimator(new DefaultItemAnimator());
        recyclerViewq.setLayoutManager(gridLayoutManager);

    }


    private void loadTvList(List<TvList> tvList){

        tvFavoriteAdapter = new TvFavoriteAdapter((ArrayList<TvList>)tvList,this,getApplicationContext());
        recyclerViewq.setAdapter(tvFavoriteAdapter);
        tvFavoriteAdapter.notifyDataSetChanged();

    }


    @Override
    public void onClick(int tvid) {

        TvList tvListdelete = new TvList();
        tvListdelete.setId(tvid);
        favoriteViewModel.delete(tvListdelete);
    }


}