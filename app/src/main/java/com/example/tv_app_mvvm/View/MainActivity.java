package com.example.tv_app_mvvm.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.tv_app_mvvm.Adapter.TvAdapter;
import com.example.tv_app_mvvm.Listener.OnTvItemClickListener;
import com.example.tv_app_mvvm.Listener.PaginationsScrollListener;
import com.example.tv_app_mvvm.Local.AppDataBase;
import com.example.tv_app_mvvm.Model.Response.BaseResponse;
import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.ViewModel.MainViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements OnTvItemClickListener {

    private ActionBarDrawerToggle mToggle;
    private ProgressBar progressBar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private static final int PAGE_START=1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int currentPage = PAGE_START;
    public static AppDataBase appDataBase;
    GridLayoutManager gridLayoutManager;
    MainViewModel mainViewModel;
    byte type=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



        appDataBase= Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"tvlistdb").allowMainThreadQueries().build();



        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getTopratedTvList(currentPage).observe(this, new Observer<BaseResponse>() {
            @Override
            public void onChanged(BaseResponse baseResponse) {


                showProgressBar();
                loadTvList(baseResponse.getResults());
                hideProgressBar();

            }
        });

        recyclerView.addOnScrollListener(new PaginationsScrollListener(gridLayoutManager) {
            @Override
            protected boolean isLoading() {
                return isLoading;
            }


            @Override
            protected boolean isLastPage() {
                return false;
            }

            @Override
            protected void loadMoreItems() {

                isLoading = true;
                currentPage += 1;

                switch (type) {
                    case 1:
                        mainViewModel.getTopratedTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {
                                loadTvList(baseResponse.getResults());

                                hideProgressBar();
                                isLoading = false;
                            }
                        });
                        break;
                    case 2:
                        mainViewModel.getPopularTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {
                                loadTvList(baseResponse.getResults());

                                //hideProgressBar();
                                isLoading = false;
                            }
                        });


                        break;

                    case 3:

                        mainViewModel.getOnairTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {
                                loadTvList(baseResponse.getResults());

                                //hideProgressBar();
                                isLoading = false;
                            }
                        });
                        break;
                    case 4:
                        mainViewModel.getOnAiringTodayTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {
                                loadTvList(baseResponse.getResults());
                                //hideProgressBar();
                                isLoading = false;
                            }
                        });
                        break;
                }
            }
        });







        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.tvtoprated:
                        showProgressBar();
                        mainViewModel.getTopratedTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {

                                loadTvList(baseResponse.getResults());
                                hideProgressBar();
                            }
                        });

                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvpopular:
                        showProgressBar();
                        mainViewModel.getPopularTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {

                                loadTvList(baseResponse.getResults());
                                hideProgressBar();
                            }
                        });
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvonair:
                        showProgressBar();
                        mainViewModel.getOnairTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {

                                loadTvList(baseResponse.getResults());
                                hideProgressBar();
                            }
                        });
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvairing:
                        showProgressBar();
                        mainViewModel.getOnAiringTodayTvList(currentPage).observe(MainActivity.this, new Observer<BaseResponse>() {
                            @Override
                            public void onChanged(BaseResponse baseResponse) {

                                loadTvList(baseResponse.getResults());
                                hideProgressBar();
                            }
                        });
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.myfavorites:

                        Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return false;




                    case R.id.exit:
                        android.os.Process.killProcess(android.os.Process.myPid());
                        MainActivity.super.onDestroy();
                        return false;

                }
                return false;
            }
        });
        
    }


    private void getResultOfSearch(String query){
        mainViewModel.getTvSearch(query).observe(MainActivity.this, new Observer<BaseResponse>() {
            @Override
            public void onChanged(BaseResponse baseResponse) {
                loadTvList(baseResponse.getResults());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem item=menu.findItem(R.id.search_tvshow);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getResultOfSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getResultOfSearch(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    public void init(){
        recyclerView = findViewById(R.id.recyclerView);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        progressBar=findViewById(R.id.progressbarr);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        mToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    private void loadTvList(List<TvList> tvLists){

        TvAdapter tvAdapter = new TvAdapter((ArrayList<TvList>)tvLists,this,getApplicationContext());

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(tvAdapter);
        tvAdapter.notifyDataSetChanged();

    }


    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }


    public void hideProgressBar() {
        if(progressBar!=null && progressBar.isShown()){
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public void onClick(int tvid) {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("tvId", tvid);
            startActivity(intent);
    }



}
