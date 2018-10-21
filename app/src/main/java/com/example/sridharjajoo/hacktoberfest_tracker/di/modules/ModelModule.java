package com.example.sridharjajoo.hacktoberfest_tracker.di.modules;

import com.example.sridharjajoo.hacktoberfest_tracker.data.GithubService;
import com.example.sridharjajoo.hacktoberfest_tracker.data.GithubServiceImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ModelModule {

    @Binds
    @Singleton
    abstract GithubService bindsGithubModule(GithubServiceImpl githubService);

}
