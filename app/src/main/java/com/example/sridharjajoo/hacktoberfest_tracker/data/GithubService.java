package com.example.sridharjajoo.hacktoberfest_tracker.data;

import io.reactivex.Observable;

public interface GithubService {

    Observable<SearchResponse> findValidPullRequests(String username);
}
