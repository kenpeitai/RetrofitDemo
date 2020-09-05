package com.example.retrofitdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitdemo.ApplicationData;
import com.example.retrofitdemo.User.UserInfo;
import com.example.retrofitdemo.view.LoginView;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.presenter.LoginPresentermpl;

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener {
    private EditText account, password;
    private Button login;
    private ProgressBar progressBar;
    private TextView register;
   private LoginPresentermpl loginPresentermpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loginPresentermpl = new LoginPresentermpl(this);




    }

    @Override
    public void startLoginActivity(UserInfo userInfo) {
        ApplicationData applicationData =(ApplicationData)this.getApplication();
        applicationData.setLogin(true);
        applicationData.setUserInfo(userInfo);
        applicationData.setPass(getPassword());
        Log.d("--------->", "startLoginActivity: " + userInfo.toString());
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("userInfo", userInfo);
        startActivity(intent);
    }


    @Override
    public void initView() {

        account = findViewById(R.id.edit_account);
        password = findViewById(R.id.edit_password);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.login_bar);
        register = findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public String getUsername() {
        return account.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismisDialog() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                showDialog();
                startActivity(new Intent(this,RegisterActivity.class));
                dismisDialog();
                break;
            case R.id.login:
               showDialog();
                loginPresentermpl.validateCredentials(getUsername(), getPassword());
                break;


        }
    }

    @Override
    protected void onDestroy() {
        loginPresentermpl.onDestroy();
        super.onDestroy();
    }
}
