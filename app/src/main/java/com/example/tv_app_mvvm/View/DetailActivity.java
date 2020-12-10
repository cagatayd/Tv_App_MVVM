package com.example.tv_app_mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tv_app_mvvm.Adapter.TvAdapter;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.Util.AppContant;
import com.example.tv_app_mvvm.ViewModel.DetailViewModel;

public class DetailActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtfirstairdate,txtorginalname,txtorginallanguage,txtpopularity,txtname,txtoverwiew;
    private ImageView backdropposter;
    DetailViewModel detailViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();

        int tvId=getIntent().getIntExtra("tvId",0);
        detailViewModel= ViewModelProviders.of(this).get(DetailViewModel.class);
        detailViewModel.getTvDetail(tvId).observe(this, new Observer<Tv_Detail>() {
            @Override
            public void onChanged(Tv_Detail tv_detail) {
                setDataToView(tv_detail);
                hideProgressBar();
            }
        });
    }

    public void init()
    {
        progressBar=findViewById(R.id.progresbar);
        txtfirstairdate=findViewById(R.id.first_air_date);
        txtname=findViewById(R.id.name);
        txtorginalname=findViewById(R.id.original_name);
        txtpopularity=findViewById(R.id.popularity);
        txtoverwiew=findViewById(R.id.overview);
        backdropposter=findViewById(R.id.backdrop_path);
        txtorginallanguage=findViewById(R.id.orginallanguage);
        showProgressBar();
    }

    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }


    public void hideProgressBar() {
        if(progressBar!=null && progressBar.isShown()){
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setDataToView(Tv_Detail tv_detail)
    {
        txtname.setText(tv_detail.name);
        txtpopularity.setText(String.valueOf("\t"+getResources().getString(R.string.popularity)+tv_detail.popularity));
        txtoverwiew.setText(tv_detail.overview);
        txtorginalname.setText("\t"+getResources().getString(R.string.orginalname)+tv_detail.original_name);
        txtfirstairdate.setText("\t"+getResources().getString(R.string.first_air_date)+tv_detail.first_air_date);
        txtorginallanguage.setText("\t"+getResources().getString(R.string.orginallanguage)+tv_detail.original_language);

        Glide.with(getApplicationContext()).load(AppContant.BASE_PATH_OF_IMAGE+tv_detail.getBackdrop_path()).into(backdropposter);

    }
}