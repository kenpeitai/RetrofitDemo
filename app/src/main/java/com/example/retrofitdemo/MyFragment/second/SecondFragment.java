package com.example.retrofitdemo.MyFragment.second;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.MyFragment.recyclerview.MyRecyclerViewAdapter;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.activity.WebActivity;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.google.gson.Gson;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.IndicatorView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondFragment extends Fragment {
    ProgressBar progressBar;
    private View view;
    private RecyclerView recyclerView;
    private Banner banner;
    private List<Uri> imageList;
    private Retrofit retrofit;
    private IndicatorView indicatorView;
    private MyRecyclerViewAdapter adapter;
    private List<ArticleBean.DatasBean> articleBeans = new ArrayList<>();
    private GetRequest_Interface getRequestInterface;
    private int nextPage = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.second_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getNetDatas();
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        showLoadBar();
                        getMoreRecyclerData(nextPage);

                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    isSlidingToLast = true;
                } else {
                    isSlidingToLast = false;
                }

            }
        });

    }

    private void getMoreRecyclerData(int next) {
        Call<UserData> call = getRequestInterface.getSquarData(next);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                nextPage++;
                UserData userData = response.body();
                List<ArticleBean.DatasBean> morerAticles = praseRecyclerData(userData.getData());
                adapter.addList(morerAticles);
                adapter.notifyDataSetChanged();
                disShowLoadBar();

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "似乎没有更多了", Toast.LENGTH_SHORT).show();
                disShowLoadBar();
            }
        });
    }

    private void getNetDatas() {
        getRecyclerData();
    }

    private void getRecyclerData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call1 = getRequestInterface.getSquarData(0);
        call1.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                nextPage = 1;
                UserData userData = response.body();
                articleBeans = praseRecyclerData(userData.getData());
                adapter = new MyRecyclerViewAdapter(articleBeans,getActivity());
                recyclerView.setAdapter(adapter);
                bindClickEvent();
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "网络似乎出现问题" + t, Toast.LENGTH_SHORT).show();

            }
        });

    }


    private List<ArticleBean.DatasBean> praseRecyclerData(Object obj) {
        Gson gson = new Gson();
        String s = gson.toJson(obj);
        ArticleBean articleBean = gson.fromJson(s, ArticleBean.class);
        articleBeans = articleBean.getDatas();
        return articleBeans;
    }


    private void initView() {
        progressBar = view.findViewById(R.id.load_more_bar);
        recyclerView = view.findViewById(R.id.squar_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    private void showLoadBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    private void disShowLoadBar() {
        progressBar.setVisibility(View.GONE);

    }
    private void bindClickEvent() {
        adapter.setOnItemClickListener((view, position, list) -> {
            Intent intent = new Intent(this.getActivity(), WebActivity.class);
            String uri = list.get(position).getLink();
            intent.putExtra("URI",uri);
            startActivity(intent);

        });
    }
}
