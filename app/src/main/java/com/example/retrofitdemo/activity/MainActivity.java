package com.example.retrofitdemo.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.retrofitdemo.ApplicationData;
import com.example.retrofitdemo.MyFragment.first.FirstFragment;
import com.example.retrofitdemo.MyFragment.forth.ForthFragmentLogin;
import com.example.retrofitdemo.MyFragment.forth.ForthFragmentUnLogin;
import com.example.retrofitdemo.MyFragment.recyclerview.bean.ArticleBean;
import com.example.retrofitdemo.MyFragment.second.SecondFragment;
import com.example.retrofitdemo.MyFragment.third.ThirdFragment;
import com.example.retrofitdemo.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private ViewPager fragmentVp;
    private RadioGroup tabsRg;
    private RadioButton todayTab;
    private RadioButton recordTab;
    private RadioButton contactTab;
    private RadioButton settingsTab;
    private List<Fragment> mFragments;
    private MyFragmentPagerAdapter mAdapter;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private ForthFragmentUnLogin forthFragmentUnLogin;

    private SearchView searchEditFrame;
    private boolean isKeyUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        searchEditFrame.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, SearchPageActivity.class);
                intent.putExtra("KEY_WORD", query);
                startActivity(intent);
                searchEditFrame.setQuery("", false);
                searchEditFrame.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private List<ArticleBean.DatasBean> praseResponseData(Object data) {
        Gson gson = new Gson();
        String s = gson.toJson(data);
        return gson.fromJson(s, ArticleBean.class).getDatas();
    }


    private void initViews() {

        searchEditFrame = findViewById(R.id.search_edit_frame);
        searchEditFrame.setIconified(true);
        searchEditFrame.onActionViewExpanded();
        searchEditFrame.setSubmitButtonEnabled(true);
        searchEditFrame.clearFocus();

        fragmentVp = findViewById(R.id.fragment_vp);
        tabsRg = findViewById(R.id.tabs_rg);
        todayTab = findViewById(R.id.today_tab);
        recordTab = findViewById(R.id.record_tab);
        contactTab = findViewById(R.id.contact_tab);
        settingsTab = findViewById(R.id.settings_tab);
        tabsRg.setOnCheckedChangeListener(this);
        mFragments = new ArrayList<>(4);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        forthFragmentUnLogin = new ForthFragmentUnLogin();
        mFragments.add(firstFragment);
        mFragments.add(secondFragment);
        mFragments.add(thirdFragment);
        {
            ApplicationData applicationData = (ApplicationData) getApplication();
            if (applicationData.isLogin()) {
mFragments.add(new ForthFragmentLogin());
            } else {
                mFragments.add(forthFragmentUnLogin);
            }
        }
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        fragmentVp.setOffscreenPageLimit(4);
        fragmentVp.setAdapter(mAdapter);
        fragmentVp.setCurrentItem(0);
        fragmentVp.addOnPageChangeListener(this);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton radioButton = (RadioButton) tabsRg.getChildAt(position);
        radioButton.setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            if (group.getChildAt(i).getId() == checkedId) {
                fragmentVp.setCurrentItem(i);
                return;
            }
        }
    }

    @Override
    protected void onResume() {
//        searchEditFrame.setIconified(true);
//        searchEditFrame.onActionViewExpanded();
//        searchEditFrame.setSubmitButtonEnabled(true);
        searchEditFrame.clearFocus();
        super.onResume();
    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return this.mList == null ? null : this.mList.get(position);
        }

        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }
    }

}

