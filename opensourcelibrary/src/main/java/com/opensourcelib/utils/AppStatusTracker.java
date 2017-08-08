package com.opensourcelib.utils;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hjy on 2017/6/13.
 *
 * app监控
 *
 */
public class AppStatusTracker implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = AppStatusTracker.class.getSimpleName();

    private static final long MAX_INTERVAL = 5 * 60 * 1000;
    private static AppStatusTracker tracker;
    private Application application;
    private boolean isForground;
    private int activeCount;
    private long timestamp;

    private AppStatusTracker(Application application) {
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public static void init(Application application) {
        tracker = new AppStatusTracker(application);
    }

    public static AppStatusTracker getInstance() {
        return tracker;
    }

    public boolean isForground() {
        return isForground;
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

        if (activeCount == 0){
            timestamp = System.currentTimeMillis();
        }
        activeCount++;

        Log.i(TAG, "打开了："+activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        isForground = true;
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.i(TAG, "关闭了："+activity.getClass().getSimpleName());
        activeCount--;
        if (activeCount == 0) {
            isForground = false;
            timestamp = System.currentTimeMillis() - timestamp;
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}