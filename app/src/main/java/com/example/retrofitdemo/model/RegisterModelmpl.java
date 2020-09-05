package com.example.retrofitdemo.model;

import com.example.retrofitdemo.User.UserInfo;
import com.google.gson.Gson;

public class RegisterModelmpl implements RegisterModel {
    @Override
    public UserInfo getRegisterInfo(Object loginInfo) {
        Gson gson = new Gson();
        String s = gson.toJson(loginInfo);
        return gson.fromJson(s,UserInfo.class);
    }
}
