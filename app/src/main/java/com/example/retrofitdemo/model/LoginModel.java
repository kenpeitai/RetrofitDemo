package com.example.retrofitdemo.model;

import com.example.retrofitdemo.User.UserInfo;

public interface LoginModel {
    interface OnLoginFinishedListener {
        void onUsernameError();//用户名错误

        void onPasswordError();//密码错误

        void onSuccess();//成功
    }


    UserInfo getLoginInfo(Object loginInfo);

}

