package com.example.tv_app_mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class FavoriteActivity extends AppCompatActivity implements OnTvItemDeleteClickListener {


    GridLayoutManager gridLayoutManager;
    TvFavoriteAdapter tvFavoriteAdapter;
    private RecyclerView recyclerViewq;
    List<TvList> tvListse= MainActivity.appDataBase.myDao().gettvshowlists();


    FavoriteViewModel favoriteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        init();

        loadTvList(tvListse);


    }

    public void init()
    {
        recyclerViewq=findViewById(R.id.recyclerViewfavorite);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewq.setItemAnimator(new DefaultItemAnimator());
        recyclerViewq.setLayoutManager(gridLayoutManager);

    }


    private void loadTvList(List<TvList> tvListse){

        tvFavoriteAdapter = new TvFavoriteAdapter((ArrayList<TvList>)tvListse,this,getApplicationContext());
        recyclerViewq.setAdapter(tvFavoriteAdapter);
        tvFavoriteAdapter.notifyDataSetChanged();

    }


    @Override
    public void onClick(int tvid) {

        TvList tvListdelete = new TvList();

        tvListdelete.setId(tvid);

//       favoriteViewModel.delete(tvListdelete);

//
//       MainActivity.appDataBase.myDao().tvshowdelete(tvListdelete);


        Log.d("TAG", "onClick: ============="+tvid);


    }


}