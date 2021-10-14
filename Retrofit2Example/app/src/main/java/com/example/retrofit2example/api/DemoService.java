package com.example.retrofit2example.api;

import com.example.retrofit2example.model.Repo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface DemoService {

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @QueryMap Map<String, Object> headers);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @Query("repoId") String repoId);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user, @Query("repoId") String repoId, @Query("testId") String testId);

//    @POST("v1/feedback")
//    Observable<Repo> sendFeedback(@Body FeedbackRequest feedbackRequest, @QueryMap(encoded = true) Map<String, Object> queries, @HeaderMap Map<String, Object> headers);

//    @POST("v1/fun")
//    Observable<BaseResponse<ComicDetail>> uploadFunComic(@Body MultipartBody body,
//                                                         @HeaderMap Map<String, Object> headers);

}
