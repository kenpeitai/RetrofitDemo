package com.example.retrofitdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.MyFragment.recyclerview.MyRecyclerViewAdapter;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchPageActivity extends AppCompatActivity {
    private SearchView searchEditSearchPage;
    private RecyclerView recyclerView;
    private int nextPage;
    private String keyword;
    private MyRecyclerViewAdapter adapter;
    private GetRequest_Interface getRequest_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        initView();
        getSearchData();
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToLast = false;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    isSlidingToLast = true;
                } else {
                    isSlidingToLast = false;
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = manager.getItemCount();
                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                        //showLoadBar();
                        getMoreRecyclerData(nextPage);
                    }
                }
            }
        });
        searchEditSearchPage.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.equals(keyword)) {
                    return false;
                }
                Call<UserData> call = getRequest_interface.doSearch(keyword, 0);
                call.enqueue(new Callback<UserData>() {
                    @Override
                    public void onResponse(Call<UserData> call, Response<UserData> response) {
                        nextPage = 1;
                        UserData userData = response.body();
                        List<ArticleBean.DatasBean> list = praseResponseData(userData.getData());
                        adapter.setmList(list);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<UserData> call, Throwable t) {

                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void getMoreRecyclerData(int next) {
        Call<UserData> call = getRequest_interface.doSearch(keyword, next);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                List<ArticleBean.DatasBean> moreList = praseResponseData(userData.getData());
                adapter.addList(moreList);
                adapter.notifyDataSetChanged();
                nextPage++;
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(SearchPageActivity.this, "似乎没有更多了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<ArticleBean.DatasBean> praseResponseData(Object data) {
        Gson gson = new Gson();
        String s = gson.toJson(data);
        return gson.fromJson(s, ArticleBean.class).getDatas();
    }

    private void getSearchData() {
        nextPage = 0;
        Intent intent = getIntent();
        keyword = intent.getStringExtra("KEY_WORD");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getRequest_interface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call = getRequest_interface.doSearch(keyword, nextPage);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {

                UserData userData = response.body();
                List<ArticleBean.DatasBean> list = praseResponseData(userData.getData());
                adapter = new MyRecyclerViewAdapter(list,SearchPageActivity.this);
                recyclerView.setAdapter(adapter);
                bindClickEvent();
                nextPage++;

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });

    }

    private void initView() {
        searchEditSearchPage = findViewById(R.id.search_edit_search_page);
        searchEditSearchPage.setIconified(true);
        searchEditSearchPage.onActionViewExpanded();
        searchEditSearchPage.setSubmitButtonEnabled(true);
        searchEditSearchPage.clearFocus();

        recyclerView = findViewById(R.id.search_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    private void bindClickEvent() {
        adapter.setOnItemClickListener((view, position, list) -> {
            Intent intent = new Intent(this, WebActivity.class);
            String uri = list.get(position).getLink();
            intent.putExtra("URI", uri);
            startActivity(intent);

        });
    }
}

