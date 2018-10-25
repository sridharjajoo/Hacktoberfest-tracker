package com.example.sridharjajoo.hacktoberfest_tracker.data;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface GithubService {

    @NonNull
    Observable<SearchResponse> findValidPullRequests(String username);
}
