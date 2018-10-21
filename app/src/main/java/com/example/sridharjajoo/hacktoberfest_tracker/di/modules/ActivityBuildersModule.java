package com.example.sridharjajoo.hacktoberfest_tracker.di.modules;

import com.example.sridharjajoo.hacktoberfest_tracker.HacktoberfestMainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract HacktoberfestMainActivity contributeshacktoberfestMainActivity();
}
