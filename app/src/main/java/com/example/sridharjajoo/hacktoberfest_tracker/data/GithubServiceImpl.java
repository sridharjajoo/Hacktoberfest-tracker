package com.example.sridharjajoo.hacktoberfest_tracker.data;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import com.example.sridharjajoo.hacktoberfest_tracker.util.DateTimeFormatter;

public class GithubServiceImpl implements GithubService {

    private final GithubApi githubApi;
    private final DateTimeFormatter customDateFormatter;
    private final Date now;

    @Inject
    public GithubServiceImpl(GithubApi githubApi) {
        this.githubApi = githubApi;
        this.customDateFormatter = new DateTimeFormatter();
        this.now = Calendar.getInstance().getTime();
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
        Calendar lastYear = Calendar.getInstance();
        lastYear.setTime(this.now);
        lastYear.add(Calendar.YEAR, -1);
        return customDateFormatter.getStringifiedDateTime(lastYear.getTime());
    }

    private String toDate() {
        return customDateFormatter.getStringifiedDateTime(this.now);
    }

    private String getPrType() {
        return "+type:pr+is:public+author:";
    }
}
