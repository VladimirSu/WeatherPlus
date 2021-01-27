package com.example.mvplibrary.mvpPackage;


import android.os.Bundle;

import com.example.mvplibrary.mvp.utils.base.BaseFragment;
import com.example.mvplibrary.mvp.utils.base.BasePresenter;
import com.example.mvplibrary.mvp.utils.base.BaseView;

/**
 * 适用于需要网络接口的Fragment
 */
public abstract class MvpFragment <P extends BasePresenter> extends BaseFragment {

    protected P mPresent;
    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresent != null){
            mPresent.detach((BaseView) this);
        }
    }
    protected abstract P createPresent();
    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent = createPresent();
        mPresent.attach((BaseView) this);
    }
}
