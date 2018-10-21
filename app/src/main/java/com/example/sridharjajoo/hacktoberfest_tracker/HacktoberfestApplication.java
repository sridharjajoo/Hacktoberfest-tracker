package com.example.sridharjajoo.hacktoberfest_tracker;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.example.sridharjajoo.hacktoberfest_tracker.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class HacktoberfestApplication extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }
}
