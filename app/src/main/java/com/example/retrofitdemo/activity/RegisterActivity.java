package com.example.retrofitdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitdemo.ApplicationData;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.User.UserInfo;
import com.example.retrofitdemo.presenter.RegisterPresentermpl;
import com.example.retrofitdemo.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener {
    private EditText user, pass, repass;
    private TextView err;
    private ProgressBar progressBar;
    private RegisterPresentermpl registerPresentermpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        registerPresentermpl = new RegisterPresentermpl(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                progressBar.setVisibility(View.VISIBLE);
                registerPresentermpl.validateCredentials(getUsername(),getPassword(),getRePassword());

        }
    }

    @Override
    public void startNewActivity(UserInfo userInfo) {
        ApplicationData applicationData =(ApplicationData)this.getApplication();
        applicationData.setLogin(true);
        applicationData.setUserInfo(userInfo);
        applicationData.setPass(getPassword());
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("userInfo",userInfo);
        startActivity(intent);
    }

    @Override
    public void initView() {
        err = findViewById(R.id.error_info);
        user = findViewById(R.id.edit_name);
        pass = findViewById(R.id.edit_password1);
        repass = findViewById(R.id.edit_password_confirm);
        Button reg = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progress_register);
        reg.setOnClickListener(this);
    }

    @Override
    public String getRePassword() {
        return repass.getText().toString();
    }

    @Override
    public String getUsername() {
        return user.getText().toString();
    }

    @Override
    public String getPassword() {
        return pass.getText().toString();
    }

    @Override
    public void toast(String msg) {
        err.setText(msg);
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
    protected void onDestroy() {
        registerPresentermpl.onDestroy();
        super.onDestroy();
    }
}
