package com.example.retrofitdemo;

import android.app.Application;

import com.example.retrofitdemo.User.UserInfo;

/*
* this is a
* */

public class ApplicationData extends Application {
    private boolean isLogin = false;
    private UserInfo userInfo;
    private String pass;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public String getPass() {
        return pass;
    }
}
