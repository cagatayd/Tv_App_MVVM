package com.example.tv_app_mvvm.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tv_app_mvvm.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        mToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.tvtoprated:
                        Toast.makeText(MainActivity.this,"TV TOPRATED",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvpopular:
                        Toast.makeText(MainActivity.this,"TV POPULER",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvonair:
                        Toast.makeText(MainActivity.this,"TV ONAİR",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        return false;

                    case R.id.tvairing:
                        Toast.makeText(MainActivity.this,"TV OnAiring",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        return false;

                }
                return false;
            }
        });
        
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


}