package com.example.sridharjajoo.hacktoberfest_tracker.di;

import com.example.sridharjajoo.hacktoberfest_tracker.HacktoberfestApplication;
import com.example.sridharjajoo.hacktoberfest_tracker.di.modules.ActivityBuildersModule;
import com.example.sridharjajoo.hacktoberfest_tracker.di.modules.ApiModule;
import com.example.sridharjajoo.hacktoberfest_tracker.di.modules.AppModule;
import com.example.sridharjajoo.hacktoberfest_tracker.di.modules.ModelModule;
import com.example.sridharjajoo.hacktoberfest_tracker.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ActivityBuildersModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class})

public interface AppComponent extends AndroidInjector<HacktoberfestApplication> {

    void inject(HacktoberfestApplication hacktoberfestApplication);
}
