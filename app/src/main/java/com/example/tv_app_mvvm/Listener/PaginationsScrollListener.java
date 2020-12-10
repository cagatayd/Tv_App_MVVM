package com.example.tv_app_mvvm.Listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class PaginationsScrollListener extends RecyclerView.OnScrollListener {
    
    GridLayoutManager gridLayoutManager;

    public PaginationsScrollListener(GridLayoutManager gridLayoutManager) {
        this.gridLayoutManager = gridLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);


        int visibleItemCount = gridLayoutManager.getChildCount(); // toplam görüntülenen item sayısı
        int totalItemCount = gridLayoutManager.getItemCount(); // tüm itemların(listenin) toplamı
        int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); // gösterilen item ın pozisyonu

        if (!isLoading() && !isLastPage()){

            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount &&
                    firstVisibleItemPosition >=0){
                loadMoreItems();
            }
        }

       

    }

    protected abstract boolean isLoading();

    protected abstract boolean isLastPage();

    protected abstract void loadMoreItems();
}
