package com.example.mvplibrary.mvp.utils.base;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvplibrary.utils.BaseApplication;

/**
 * 用于不需要请求网络接口的Activity
 */
public abstract class BaseActivity extends AppCompatActivity implements UiCallBcak{
    protected Activity context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeView(savedInstanceState);
        this.context = this;

        BaseApplication.getActivityManager().addActivity(this);
        if(getLayoutId() > 0){
            setContentView(getLayoutId());
            initData(savedInstanceState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void initBeforeView(Bundle savedInstanceState) {

    }
}
