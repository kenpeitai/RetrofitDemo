package com.example.retrofitdemo.model;

import com.example.retrofitdemo.User.UserInfo;
import com.google.gson.Gson;

public class LoginModelmpl implements LoginModel {

    @Override
    public UserInfo getLoginInfo(Object loginInfo) {

        Gson gson = new Gson();
        String s = gson.toJson(loginInfo);
        return gson.fromJson(s,UserInfo.class);
    }
}
