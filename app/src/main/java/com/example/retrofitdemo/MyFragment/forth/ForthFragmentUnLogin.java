package com.example.retrofitdemo.MyFragment.forth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.activity.LoginActivity;

public class ForthFragmentUnLogin extends Fragment {
    private View view;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forth_fragment, container, false);
        button = view.findViewById(R.id.go_login_btn);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        button.setOnClickListener(v -> {
    Intent intent  = new Intent(getActivity(), LoginActivity.class);
    startActivity(intent);

        });
        super.onViewCreated(view, savedInstanceState);
    }
}
