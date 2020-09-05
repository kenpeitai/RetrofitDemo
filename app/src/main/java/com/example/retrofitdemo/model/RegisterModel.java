package com.example.retrofitdemo.model;

import com.example.retrofitdemo.User.UserInfo;

public interface RegisterModel {

    interface OnRegisterListener {

        void onError();

        void onSuccess();
    }
    UserInfo getRegisterInfo(Object loginInfo);
}
