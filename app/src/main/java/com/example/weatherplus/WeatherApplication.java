package com.example.weatherplus;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvplibrary.utils.ActivityManager;
import com.example.mvplibrary.utils.BaseApplication;

import java.util.logging.Handler;

public class WeatherApplication extends BaseApplication {

    /**
     * 应用实例
     */
   public static WeatherApplication weatherApplication;
   private static Context context;
   private static ActivityManager activityManager;

   private static Activity sActivity;

   public static Context getMyContext(){
       return weatherApplication == null ? null : weatherApplication.getApplicationContext();
   }

   private Handler myHandler;

   public Handler getMyHandler(){
       return myHandler;
   }
   private void setMyHandler(Handler handler){
       myHandler = handler;
   }

    @Override
    public void onCreate() {
        super.onCreate();

        activityManager = new ActivityManager();
        context = getApplicationContext();
        weatherApplication = this;


        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                sActivity = activity;
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

    public static ActivityManager getActivityManager(){
       return activityManager;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //static 代码段可以防止内存泄漏
}
