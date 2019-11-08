package com.example.sridharjajoo.hacktoberfest_tracker.data;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GithubServiceImpl implements GithubService {

    private final GithubApi githubApi;
    private final int currentYear;

    @Inject
    public GithubServiceImpl(GithubApi githubApi) {
        this.githubApi = githubApi;
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public Observable<SearchResponse> findValidPullRequests(String username) {
        return githubApi.getValidPullRequest(constructParamLink(username))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private String constructParamLink(String username) {
        return getLabel() +fromDate()+".."+toDate()  + getPrType() + username;
    }

    private String getLabel() {
        return "-label:invalid+created:";
    }

    private String fromDate() {
        return this.currentYear + "-09-30T00:00:00-12:00";
    }

    private String toDate() {
        return this.currentYear + "-10-31T23:59:59-12:00";
    }

    private String getPrType() {
        return "+type:pr+is:public+author:";
    }
}
