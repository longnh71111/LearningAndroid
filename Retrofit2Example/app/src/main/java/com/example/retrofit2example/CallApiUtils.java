package com.example.retrofit2example;

import com.example.retrofit2example.api.DemoService;
import com.example.retrofit2example.api.GitHubService;
import com.example.retrofit2example.model.Repo;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

class CallApiUtils {

    public void callApi1() {
        Retrofit retrofit = RetrofitHelper.getRetrofit();

        DemoService service = RetrofitHelper.getRetrofit().create(DemoService.class);
        HashMap<String, Object> queries = new HashMap<>();
        queries.put("token", "1234");
        queries.put("repoId", 143326);
        queries.put("testId", 143326);

        Observable<List<Repo>> repos = service.listRepos("octocat", queries);
    }
}
