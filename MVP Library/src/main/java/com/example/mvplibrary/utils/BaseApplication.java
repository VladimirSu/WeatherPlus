package com.example.mvplibrary.utils;


import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

/**
 * 工程管理
 */
public class BaseApplication extends Application {
    private static ActivityManager activityManager;
    private static BaseApplication application;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //声明Activity的管理
        activityManager = new ActivityManager();
        context = getApplicationContext();
        application = this;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public static ActivityManager getActivityManager() {
        return activityManager;
    }

    public static BaseApplication getApplication() {
        return application;
    }

    public static Context getContext() {
        return context;
    }
}
