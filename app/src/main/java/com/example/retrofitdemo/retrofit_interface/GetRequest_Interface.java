package com.example.retrofitdemo.retrofit_interface;

import com.example.retrofitdemo.MyFragment.first.banner.BannerData;
import com.example.retrofitdemo.User.UserData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetRequest_Interface {
    @FormUrlEncoded
    @POST("user/login")
    Call<UserData> login(@Field("username") String account, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/register")
    Call<UserData> register(@Field("username") String account, @Field("password") String password, @Field("repassword") String repassword);

    @GET("banner/json")
    Call<UserData> getBanners();

    @GET("article/list/0/json")
    Call<UserData> getRecyclerData();

    @GET("article/top/json")
    Call<UserData> getRecyclerData1();

    @GET("user_article/list/{page}/json")
    Call<UserData> getSquarData(@Path("page") int page);

    @GET("project/tree/json")
    Call<UserData> getProjectTreeData();

    @GET("project/list/1/json")
    Call<UserData> getProjectData(@Query("cid") int id);

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Call<UserData> doSearch(@Field("k")String keyWord,@Path("page")int page);

    @GET("lg/collect/list/{id}/json")
    Call<UserData> getCollectionArticle(@Path("id")int page);
}

