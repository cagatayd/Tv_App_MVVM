package com.example.tv_app_mvvm.Service;

import com.example.tv_app_mvvm.Model.Request.TvSearch;
import com.example.tv_app_mvvm.Model.Response.BaseResponse;
import com.example.tv_app_mvvm.Model.Response.Tv_Detail;
import com.example.tv_app_mvvm.Util.AppContant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ITvService {

    @GET(AppContant.TOP_RATED_TV+AppContant.API_KEY)
    Observable<BaseResponse> getTopratedTvList(@Query("page") int PageIndex);

   @GET(AppContant.POPULAR_TV+AppContant.API_KEY)
    Observable<BaseResponse>getPopularTvList(@Query("page") int PageIndex);

   @GET(AppContant.ONAIR_TV+AppContant.API_KEY)
    Observable<BaseResponse>getOnAirTvList(@Query("page") int PageIndex);

   @GET(AppContant.TV_AIRING+AppContant.API_KEY)
    Observable<BaseResponse>getTvAiringList(@Query("page") int PageIndex);


   @GET(AppContant.TV_DETAIL+AppContant.API_KEY)
    Observable<Tv_Detail>getTvDetail(@Path("tv_id") int tv_id);

   @GET(AppContant.TV_SEARCH+AppContant.API_KEY)
    Observable<BaseResponse>getTvSearch(@Query("query") String query);
}
