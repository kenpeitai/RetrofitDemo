package com.example.retrofitdemo.presenter;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.example.retrofitdemo.ApplicationData;
import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.User.UserInfo;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.example.retrofitdemo.view.LoginView;
import com.example.retrofitdemo.model.LoginModel;
import com.example.retrofitdemo.model.LoginModelmpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresentermpl implements LoginPresenter, LoginModel.OnLoginFinishedListener {
    private LoginView loginView;
    public LoginModel loginModel;
    private UserData info;

    public LoginPresentermpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelmpl();
    }

    @Override
    public void onUsernameError() {
//暂时不用
    }

    @Override
    public void onPasswordError() {
        loginView.toast("登录失败，密码与账户不匹配");
        loginView.dismisDialog();
    }

    @Override
    public void onSuccess() { ;
        Log.d("-------------------->", "onSuccess: " + this.info.getData().toString());
        UserInfo userInfo = loginModel.getLoginInfo(this.info.getData());
        loginView.startLoginActivity(userInfo);
        loginView.toast("登录成功");
        loginView.dismisDialog();

    }

    @Override
    public void validateCredentials(String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call = getRequestInterface.login(username, password);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {

                info = response.body();
                switch (info.getErrorCode()) {
                    default:
                        onPasswordError();
                        break;
                    case 0:
                        onSuccess();
                        break;
                    case -1:
                        onPasswordError();
                        break;
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                System.out.println("failure" + t);
            }
        });
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
