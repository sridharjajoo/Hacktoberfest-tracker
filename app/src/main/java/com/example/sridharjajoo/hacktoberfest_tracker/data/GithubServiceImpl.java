package com.example.sridharjajoo.hacktoberfest_tracker.data;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GithubServiceImpl implements GithubService {

    private final GithubApi githubApi;

    @Inject
    public GithubServiceImpl(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @Override
    public Observable<SearchResponse> findValidPullRequests(String username) {
        String str = "-label:invalid+created:" + "2018-09-30T00:00:00-12:00..2018-10-31T23:59:59-12:00" + "+type:pr+is:public+author:" + username;
        return githubApi.getValidPullRequest(str)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
