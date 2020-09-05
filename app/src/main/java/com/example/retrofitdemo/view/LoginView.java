package com.example.retrofitdemo.view;

import com.example.retrofitdemo.User.UserInfo;

public interface LoginView {
    void startLoginActivity(UserInfo userInfo);
    void initView();
    String getUsername();
    String getPassword();
    void toast(String msg);
    void showDialog();
    void dismisDialog();
}
