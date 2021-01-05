package com.example.tv_app_mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tv_app_mvvm.Adapter.TvAdapter;
import com.example.tv_app_mvvm.Adapter.TvFavoriteAdapter;
import com.example.tv_app_mvvm.Listener.OnTvItemClickListener;
import com.example.tv_app_mvvm.Listener.OnTvItemClickListener2;
import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.ViewModel.FavoriteViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity implements OnTvItemClickListener2 {


    GridLayoutManager gridLayoutManager;
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

        TvFavoriteAdapter tvFavoriteAdapter = new TvFavoriteAdapter((ArrayList<TvList>)tvListse,this,getApplicationContext());
        recyclerViewq.setAdapter(tvFavoriteAdapter);
        tvFavoriteAdapter.notifyDataSetChanged();

    }


    @Override
    public void onClick(int tvid) {
        Log.d("TAG", "onClick: ============="+tvid);

                    TvList tvListdelete = new TvList();

                    tvListdelete.setId(tvid);

                    MainActivity.appDataBase.myDao().tvshowdelete(tvListdelete);

    }
}