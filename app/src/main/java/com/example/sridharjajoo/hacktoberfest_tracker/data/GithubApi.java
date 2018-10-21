package com.example.sridharjajoo.hacktoberfest_tracker.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubApi {

    @GET("search/issues")
    Observable<SearchResponse> getValidPullRequest(@Query(encoded = true, value = "q") String searchQuery);
}
