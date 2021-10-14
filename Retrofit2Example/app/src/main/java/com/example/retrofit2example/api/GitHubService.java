package com.example.retrofit2example.api;

import com.example.retrofit2example.model.Repo;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GitHubService {

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @HeaderMap Map<String, Object> headers);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @Query("repoId") String repoId);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @Query("repoId") String repoId, @Query("testId") String testId);

    @GET("users/{user}/data")
    Observable<List<Repo>> listData(@Path("user") String user, @QueryMap Map<String, Object> repoId);

}
