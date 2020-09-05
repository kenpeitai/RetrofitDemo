package com.example.retrofitdemo.presenter;

public interface RegisterPresenter {
    void validateCredentials(String username, String password,String repassword);

    void onDestroy();
}
