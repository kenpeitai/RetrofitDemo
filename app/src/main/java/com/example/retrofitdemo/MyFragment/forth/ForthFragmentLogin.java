package com.example.retrofitdemo.MyFragment.forth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.MyFragment.recyclerview.MyRecyclerViewAdapter;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.activity.WebActivity;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForthFragmentLogin extends Fragment {
    private View view;
    private ImageView drawerBack;
    private RecyclerView drawerRecycler;
    private CardView cardUserLike;
    private DrawerLayout drawerLayout;
    private Retrofit retrofit;
    private int nextPage;
    private MyRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forth_fragment_logined, container, false);
        initView();
        return view;
    }

    private void initView() {

        cardUserLike = view.findViewById(R.id.card_user_like);
        drawerLayout = view.findViewById(R.id.my_drawer);

        drawerBack = view.findViewById(R.id.drawer_back);
        drawerRecycler = view.findViewById(R.id.drawer_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        drawerRecycler.setHasFixedSize(true);
        drawerRecycler.setItemAnimator(new DefaultItemAnimator());
        drawerRecycler.setLayoutManager(layoutManager);
        drawerRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getRecyclerData();

        cardUserLike.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.END);

        });

        drawerBack.setOnClickListener(v -> {
            drawerLayout.closeDrawer(GravityCompat.END);

        });
        super.onViewCreated(view, savedInstanceState);
    }

    private void getRecyclerData() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call1 = getRequestInterface.getSquarData(0);
        call1.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                nextPage = 1;
                UserData userData = response.body();
                List<ArticleBean.DatasBean> articleBeans = praseRecyclerData(userData.getData());
                adapter = new MyRecyclerViewAdapter(articleBeans,getActivity());
                drawerRecycler.setAdapter(adapter);
                bindClickEvent();
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });
    }

    private List<ArticleBean.DatasBean> praseRecyclerData(Object obj) {
        Gson gson = new Gson();
        String s = gson.toJson(obj);
        ArticleBean articleBean = gson.fromJson(s, ArticleBean.class);
        List<ArticleBean.DatasBean> articleBeans = articleBean.getDatas();
        return articleBeans;
    }

    private void bindClickEvent() {
        adapter.setOnItemClickListener((view, position, list) -> {
            Intent intent = new Intent(this.getActivity(), WebActivity.class);
            String uri = list.get(position).getLink();
            intent.putExtra("URI", uri);
            startActivity(intent);

        });
    }
}