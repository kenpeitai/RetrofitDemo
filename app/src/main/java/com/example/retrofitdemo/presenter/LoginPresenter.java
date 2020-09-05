package com.example.retrofitdemo.presenter;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
