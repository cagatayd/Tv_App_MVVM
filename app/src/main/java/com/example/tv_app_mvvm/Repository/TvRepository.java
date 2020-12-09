package com.example.tv_app_mvvm.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.tv_app_mvvm.Model.Request.TvSearch;
import com.example.tv_app_mvvm.Model.Response.BaseResponse;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.Service.ITvService;
import com.example.tv_app_mvvm.Util.AppContant;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvRepository {

    private static TvRepository tvRepositoryinstance;


    private ITvService iTvService;

    public MutableLiveData<BaseResponse>topratedtv=new MutableLiveData<>();
    public MutableLiveData<BaseResponse>populartv=new MutableLiveData<>();
    public MutableLiveData<BaseResponse>onairtv=new MutableLiveData<>();
    public MutableLiveData<BaseResponse>onairingtodaytv=new MutableLiveData<>();
    public MutableLiveData<Tv_Detail>tvdetail=new MutableLiveData<>();
    public MutableLiveData<BaseResponse>searchtv=new MutableLiveData<>();// search te de sonuçlar baseresponstaki gibi dönüyor

    public TvRepository() {

        iTvService=new Retrofit.Builder()
                .baseUrl(AppContant.SERVİCE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ITvService.class);
    }

    public static TvRepository getInstance()
    {
        if (tvRepositoryinstance==null)
        {
            synchronized (TvRepository.class){
                tvRepositoryinstance=new TvRepository();
            }
        }
        return tvRepositoryinstance;
    }

    public MutableLiveData<BaseResponse>  getTopRatedTvList() {
        iTvService.getTopratedTvList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {

                        topratedtv.setValue(baseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return topratedtv;


    }

    public MutableLiveData<BaseResponse>getPopulartvList(){
        iTvService.getPopularTvList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {

                        populartv.setValue(baseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return populartv;

    }


    public MutableLiveData<BaseResponse>getOnairtvList(){
        iTvService.getOnAirTvList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {

                        onairtv.setValue(baseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return onairtv;
    }

    public MutableLiveData<BaseResponse>getOnairingtodaytvList(){
        iTvService.getTvAiringList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {

                        onairingtodaytv.setValue(baseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return onairingtodaytv;
    }


    public MutableLiveData<Tv_Detail>getTvdetail(int tv_id){
        iTvService.getTvDetail(tv_id)
        .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Tv_Detail>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Tv_Detail tv_detail) {

                        tvdetail.setValue(tv_detail);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return tvdetail;
    }


    public MutableLiveData<BaseResponse>getTvSearch(String query){
        iTvService.getTvSearch(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponse baseResponse) {

                        searchtv.setValue(baseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return searchtv;
    }

















}
