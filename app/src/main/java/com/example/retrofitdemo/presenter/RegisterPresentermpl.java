package com.example.retrofitdemo.presenter;

import com.example.retrofitdemo.User.UserData;
import com.example.retrofitdemo.User.UserInfo;
import com.example.retrofitdemo.model.RegisterModel;
import com.example.retrofitdemo.model.RegisterModelmpl;
import com.example.retrofitdemo.retrofit_interface.GetRequest_Interface;
import com.example.retrofitdemo.view.RegisterView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterPresentermpl implements RegisterPresenter, RegisterModel.OnRegisterListener {
    private RegisterView registerView;
    private RegisterModel registerModel;
    private UserData info;

    public RegisterPresentermpl(RegisterView registerView) {
        this.registerView = registerView;
        registerModel = new RegisterModelmpl();
    }

    @Override
    public void validateCredentials(String username, String password, String repassword) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequest_Interface getRequestInterface = retrofit.create(GetRequest_Interface.class);
        Call<UserData> call = getRequestInterface.register(username, password, repassword);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                info = response.body();
                switch (info.getErrorCode()) {
                    default:
                        onError();
                        break;
                    case 0:
                        onSuccess();
                        break;
                    case -1:
                        onError();
                        break;
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                registerView.toast("网络似乎出现问题" + t);
            }
        });
    }

    @Override
    public void onDestroy() {
        registerView = null;
    }

    @Override
    public void onError() {
        registerView.toast("注册失败!" + info.getErrorMsg());
        registerView.dismisDialog();
    }

    @Override
    public void onSuccess() {
        UserInfo userInfo = registerModel.getRegisterInfo(this.info.getData());
        registerView.startNewActivity(userInfo);
        registerView.toast("注册成功!");
        registerView.dismisDialog();
    }
}
