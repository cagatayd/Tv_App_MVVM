package com.example.tv_app_mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tv_app_mvvm.Adapter.TvAdapter;
import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.Util.AppContant;
import com.example.tv_app_mvvm.ViewModel.DetailViewModel;
import com.example.tv_app_mvvm.ViewModel.FavoriteViewModel;

import java.io.ByteArrayOutputStream;

public class DetailActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txtfirstairdate,txtorginalname,txtorginallanguage,txtpopularity,txtname,txtoverwiew;
    private ImageView backdropposter;
    private Button btnsave;
    private String imgdata;

    DetailViewModel detailViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();

        TvList tvList = new TvList();

        int tvId=getIntent().getIntExtra("tvId",0);

                detailViewModel = new ViewModelProvider(getViewModelStore(),
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(DetailViewModel.class);
        detailViewModel.getTvDetail(tvId).observe(this, new Observer<Tv_Detail>() {
            @Override
            public void onChanged(Tv_Detail tv_detail) {
                setDataToView(tv_detail);
                hideProgressBar();


            }
        });



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String name=txtname.getText().toString();
                    tvList.setId(tvId);
                    tvList.setTitle(name);
                    tvList.setPoster_path(imgdata);

                    detailViewModel.insert(tvList);

                    Toast.makeText(DetailActivity.this,"added to favorites",Toast.LENGTH_LONG).show();
                    onBackPressed();

                }catch (Exception e)
                {
                  Toast.makeText(DetailActivity.this,"Already added to favorites",Toast.LENGTH_LONG).show();

                }

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
        btnsave=findViewById(R.id.addFav);


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

         imgdata=AppContant.BASE_PATH_OF_IMAGE+tv_detail.getBackdrop_path();


    }






}