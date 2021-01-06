package com.example.tv_app_mvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tv_app_mvvm.Listener.OnTvItemDeleteClickListener;
import com.example.tv_app_mvvm.Model.Response.TvList;
import com.example.tv_app_mvvm.R;
import com.example.tv_app_mvvm.View.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class TvFavoriteAdapter extends RecyclerView.Adapter<TvFavoriteAdapter.ViewHolder> {

    List<TvList> tvLists;
    Context context;
    OnTvItemDeleteClickListener listener2;
    int ids;



    public TvFavoriteAdapter(ArrayList<TvList> tvLists, OnTvItemDeleteClickListener listener2, Context applicationContext) {
        this.listener2 = listener2;
        this.context=applicationContext;
        this.tvLists=tvLists;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_favorite_item,parent,false);
        return new ViewHolder(view1);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtfavoriteid.setText(String.valueOf(tvLists.get(position).getId()));
        holder.txtfavoritetitle.setText(tvLists.get(position).getTitle());
        Glide.with(context).load(tvLists.get(position).poster_path).into(holder.imgfavoriteposter);
    }

    @Override
    public int getItemCount() {
        return tvLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView imgfavoriteposter;
        TextView txtfavoritetitle;
        TextView txtfavoriteid;
        Button btndelete;


        public ViewHolder(@NonNull View itemView)  {
            super(itemView);

            imgfavoriteposter=itemView.findViewById(R.id.favposter);
            txtfavoritetitle=itemView.findViewById(R.id.posterfavtitle);
            txtfavoriteid=itemView.findViewById(R.id.favid);
            btndelete=itemView.findViewById(R.id.btndelete);

            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     ids=tvLists.get(getAdapterPosition()).getId();
                     listener2.onClick(ids);
                }
            });

        }

    }

}
