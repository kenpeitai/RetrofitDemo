package com.example.retrofitdemo.view;

import com.example.retrofitdemo.User.UserInfo;

public interface RegisterView {
    void startNewActivity(UserInfo userInfo);
    void initView();
    String getRePassword();
    String getUsername();
    String getPassword();
    void toast(String msg);
    void showDialog();
    void dismisDialog();
}
