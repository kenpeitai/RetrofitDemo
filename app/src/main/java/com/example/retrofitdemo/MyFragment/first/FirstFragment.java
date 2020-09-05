package com.example.retrofitdemo.MyFragment.first;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.MyFragment.first.banner.BannerData;
import com.example.retrofitdemo.MyFragment.first.banner.ImageHolderCreator;
import com.example.retrofitdemo.MyFragment.recyclerview.MyRecyclerViewAdapter;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.activity.WebActivity;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.IndicatorView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment {
    private ProgressBar firstBar1;
    private ProgressBar firstBar2;
    private View view;
    private RecyclerView recyclerView;
    private Banner banner;
    private List<Uri> imageList;
    private IndicatorView indicatorView;
    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<ArticleBean.DatasBean> articleBeans, articleTopBeans = new ArrayList<>();
    private Retrofit retrofit;
    private GetRequest_Interface getRequestInterface;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.first_fragment, container, false);
        initView();
        showBar(firstBar1);
        showBar(firstBar2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getNetDatas();


    }

    private void bindClickEvent() {
        adapter.setOnItemClickListener((view, position, list) -> {
            Intent intent = new Intent(this.getActivity(), WebActivity.class);
            String uri = list.get(position).getLink();
            intent.putExtra("URI",uri);
            startActivity(intent);

        });
    }

    private void getNetDatas() {
        getBannerData();
        getRecyclerData();
    }

    private void getRecyclerData() {
        Call<UserData> call1 = getRequestInterface.getRecyclerData1();
        call1.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                articleTopBeans = praseRecyclerTopData(userData.getData());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });
        Call<UserData> call = getRequestInterface.getRecyclerData();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                articleBeans = praseRecyclerData(userData.getData());

                while (articleTopBeans.isEmpty()) {
                    ;
                }
                articleTopBeans.addAll(articleBeans);
                adapter = new MyRecyclerViewAdapter(articleTopBeans,getActivity());
                recyclerView.setAdapter(adapter);
                disShowBar(firstBar2);
                bindClickEvent();

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "网络似乎出现问题" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<ArticleBean.DatasBean> praseRecyclerTopData(Object data) {
        Gson gson = new Gson();
        String s = gson.toJson(data);
        articleTopBeans = gson.fromJson(s, new TypeToken<List<ArticleBean.DatasBean>>() {
        }.getType());
        return articleTopBeans;
    }

    private List<ArticleBean.DatasBean> praseRecyclerData(Object data) {
        Gson gson = new Gson();
        String s = gson.toJson(data);
        ArticleBean articleBean = gson.fromJson(s, ArticleBean.class);
        articleBeans = articleBean.getDatas();


        return articleBeans;
    }

    private void getBannerData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call = getRequestInterface.getBanners();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                imageList = praseBannerData(userData.getData());
                banner.setIndicator(indicatorView)
                        .setHolderCreator(new ImageHolderCreator())
                        .setPages(imageList);
                disShowBar(firstBar1);
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "网络似乎出现问题" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Uri> praseBannerData(Object o) {
        Gson gson = new Gson();
        String s = gson.toJson(o);
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(s).getAsJsonArray();
        ArrayList<Uri> bannerData = new ArrayList<>();
        for (JsonElement user : jsonArray) {
            BannerData data = gson.fromJson(user, BannerData.class);
            bannerData.add(Uri.parse(data.getImagePath()));
        }
        Log.d("--------->", "praseData: " + bannerData.toString());
        return bannerData;
    }

    private void initView() {


        firstBar1 = view.findViewById(R.id.first_bar1);
        firstBar1.bringToFront();
        firstBar2 = view.findViewById(R.id.first_bar2);

        recyclerView = view.findViewById(R.id.hot_recycler);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        banner = view.findViewById(R.id.banner);
        indicatorView = new IndicatorView(getContext())
                .setIndicatorColor(Color.DKGRAY)
                .setIndicatorSelectorColor(Color.WHITE);


    }

    private void showBar(ProgressBar bar) {
        bar.setVisibility(View.VISIBLE);
    }

    private void disShowBar(ProgressBar bar) {
        bar.setVisibility(View.GONE);
    }
}
