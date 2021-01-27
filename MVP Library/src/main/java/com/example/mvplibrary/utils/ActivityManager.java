package com.example.mvplibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * 管理所有的Activity
 */
public class ActivityManager {
    private List<Activity> allActivities = new ArrayList<>();   //保存所有创建的Activity


    /*
     *添加Activity到管理器
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            allActivities.add(activity);
        }
    }


    /**
     * 从管理器移除Activity
     */
    public void removeActivity(Activity activity){
        if (activity != null){
            allActivities.remove(activity);
        }
    }


    /**
     * 关闭所有Activity
     */
    public void finishAll(){
        for (Activity activity : allActivities){
            activity.finish();
        }
    }
    public Activity getTaskTop(){
        return allActivities.get(allActivities.size() - 1);
    }
}
