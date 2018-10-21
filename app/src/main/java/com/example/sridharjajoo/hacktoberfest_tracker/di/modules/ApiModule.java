package com.example.sridharjajoo.hacktoberfest_tracker.di.modules;

import com.example.sridharjajoo.hacktoberfest_tracker.data.GithubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public GithubApi providesGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }
}
