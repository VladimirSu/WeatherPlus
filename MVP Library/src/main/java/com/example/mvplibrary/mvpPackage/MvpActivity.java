package com.example.mvplibrary.mvpPackage;


import android.os.Bundle;

import com.example.mvplibrary.mvp.utils.base.BaseActivity;
import com.example.mvplibrary.mvp.utils.base.BasePresenter;
import com.example.mvplibrary.mvp.utils.base.BaseView;


/**
 * 适用于需要网络接口的Activity
 */
public abstract class MvpActivity <P extends BasePresenter> extends BaseActivity {
    protected P mPresent;

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent = createPresenter();
        mPresent.attach((BaseView)this);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent.detach((BaseView) this);
    }
}
