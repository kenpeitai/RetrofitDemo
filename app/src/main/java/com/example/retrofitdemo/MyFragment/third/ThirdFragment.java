package com.example.retrofitdemo.MyFragment.third;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.MyFragment.recyclerview.CardRecyclerViewAdapter;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.CardBean;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ClassficationBean;
import com.example.retrofitdemo.MyFragment.recyclerview.ClassficationRecyclerViewAdapter;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.activity.WebActivity;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThirdFragment extends Fragment {
    private Retrofit retrofit;
    private CardView card;
    private ImageView cardImage;
    private TextView cardTitle;
    private TextView cardDetails;
    private TextView cardInfo;
    private CheckBox cardLikeTab;
    private RecyclerView kindsRecycler;
    private RecyclerView cardContainerRecycler;
    private GetRequest_Interface getRequestInterface;
    private View view;
    private ClassficationRecyclerViewAdapter adapter;
    private CardRecyclerViewAdapter adapter1;
    private List<ClassficationBean.DataBean> treeList;
    private List<CardBean.DataBean.DatasBean> projectList;
    private LinearLayoutManager layoutManager;
    private ProgressBar bar1, bar2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.third_fragment, container, false);
        initView();
        showBar1();
        showBar2();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDataFromNet();

    }

    private void getDataFromNet() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call = getRequestInterface.getProjectTreeData();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                treeList = praseTreeData(userData.getData());
                adapter = new ClassficationRecyclerViewAdapter(treeList);
                kindsRecycler.setAdapter(adapter);
                setClickEvent(adapter);
                disShowBar1();
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "网络似乎出现问题", Toast.LENGTH_SHORT).show();
            }
        });
        Call<UserData> call1 = getRequestInterface.getProjectData(294);
        call1.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                UserData userData = response.body();
                projectList = praseProjectData(userData.getData());
                adapter1 = new CardRecyclerViewAdapter(projectList);
                cardContainerRecycler.setAdapter(adapter1);
                bindClickEvent();
                diaShowBar2();
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Toast.makeText(getContext(), "网络似乎出现问题", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setClickEvent(ClassficationRecyclerViewAdapter adapter) {
        adapter.setOnItemClickListener(new ClassficationRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (adapter.getIsClicks().get(position)) {
                    return;
                }
                showBar2();
                moveToMiddle(kindsRecycler, position);
                int id = treeList.get(position).getId();
                Call<UserData> call = getRequestInterface.getProjectData(id);
                call.enqueue(new Callback<UserData>() {
                    @Override
                    public void onResponse(Call<UserData> call, Response<UserData> response) {
                        UserData userData = response.body();
                        projectList = praseProjectData(userData.getData());
                        adapter1.setList(projectList);
                        adapter1.notifyDataSetChanged();
                        diaShowBar2();

                    }

                    @Override
                    public void onFailure(Call<UserData> call, Throwable t) {

                    }
                });
            }
        });

    }

    private void moveToMiddle(RecyclerView title_recyclerView, int position) {
        int firstPosition = layoutManager.findFirstVisibleItemPosition();
        int lastPosition = layoutManager.findLastVisibleItemPosition();
        int left = title_recyclerView.getChildAt(position - firstPosition).getLeft();
        int right = title_recyclerView.getChildAt(lastPosition - position).getLeft();
        title_recyclerView.scrollBy((left - right) / 2, 0);

    }

    private List<CardBean.DataBean.DatasBean> praseProjectData(Object obj) {
        Gson gson = new Gson();
        String s = gson.toJson(obj);
        return gson.fromJson(s, CardBean.DataBean.class).getDatas();

    }

    private List<ClassficationBean.DataBean> praseTreeData(Object obj) {
        Gson gson = new Gson();
        String s = gson.toJson(obj);
        return gson.fromJson(s, new TypeToken<List<ClassficationBean.DataBean>>() {
        }.getType());

    }
    private void bindClickEvent() {
        adapter1.setOnItemClickListener((view, position, list) -> {
            Intent intent = new Intent(this.getActivity(), WebActivity.class);
            String uri = list.get(position).getLink();
            intent.putExtra("URI",uri);
            startActivity(intent);

        });
    }


    private void initView() {
        bar1 = view.findViewById(R.id.load_bar1);
        bar2 = view.findViewById(R.id.load_bar2);
        kindsRecycler = view.findViewById(R.id.kinds_recycler);
        cardContainerRecycler = view.findViewById(R.id.card_container_recycler);
        card = view.findViewById(R.id.card);
        cardImage = view.findViewById(R.id.card_image);
        cardTitle = view.findViewById(R.id.card_title);
        cardDetails = view.findViewById(R.id.card_details);
        cardInfo = view.findViewById(R.id.card_info);
        cardLikeTab = view.findViewById(R.id.card_like_tab);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        cardContainerRecycler.setLayoutManager(gridLayoutManager);
        cardContainerRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        kindsRecycler.setLayoutManager(layoutManager);
        kindsRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    private void showBar1() {
        bar1.setVisibility(View.VISIBLE);
    }

    private void showBar2() {
        bar2.setVisibility(View.VISIBLE);
    }

    private void disShowBar1() {
        bar1.setVisibility(View.GONE);
    }

    private void diaShowBar2() {
        bar2.setVisibility(View.GONE);
    }
}
