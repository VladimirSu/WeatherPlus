package com.example.mvplibrary.mvp.utils.base;

import java.lang.ref.WeakReference;

/**
 * Presenter基类 操作视图View
 */
public class BasePresenter <V extends BaseView>{
    private WeakReference<V> mWeakReference;

    /**
     * 关联view
     */
    public void attach(V v){
        mWeakReference = new WeakReference<V>(v);
    }

    /**
     * 分离View
     */
    public void detach(V v){
        if(mWeakReference != null){
            mWeakReference.clear();;
            mWeakReference = null;
        }
    }

    /**
     * 获取View
     */
    public V getView(){
        if(mWeakReference != null){
            return mWeakReference.get();
        }
        return null;
    }
}
