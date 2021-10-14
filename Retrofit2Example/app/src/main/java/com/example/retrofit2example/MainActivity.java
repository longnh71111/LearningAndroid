package com.example.retrofit2example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofit2example.api.GitHubService;
import com.example.retrofit2example.model.Repo;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 20 * 1000;
    //写入时间
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20 * 1000;
    //超时时间
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20 * 1000;
    //最大缓存
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 20 * 1024 * 1024;//设置20M
    //长缓存有效期为7天
    private static final int CACHE_STALE_LONG = 60 * 60 * 24 * 7;

    TextView btnGetData;

    private Cache getCache(Context context) {
        Cache cache = null;
        String path = createRootPath(context);
        final File baseDir = new File(path);
        final File cacheDir = new File(baseDir, "CopyCache");
        cache = new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
        return cache;
    }

    public static String createRootPath(Context context) {
        String cacheRootPath = "";
        if (isSdCardAvailable()) {
            // /sdcard/Android/data/<application package>/cache
            cacheRootPath = context.getExternalCacheDir().getPath();
        } else {
            // /data/data/<application package>/cache
            cacheRootPath = context.getCacheDir().getPath();
        }
        return cacheRootPath;
    }

    public static boolean isSdCardAvailable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

//    private Interceptor mRewriteCacheControlInterceptor = chain -> {
//        Request request = chain.request();
//        // Logger.d(NetworkUtils.isAvailable(mContext));
//        if (!NetworkUtils.isConnected(this)) {
//            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
//        }
//        Response originalResponse = chain.proceed(request);
//        if (NetworkUtils.isConnected(this)) {
//            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//            String cacheControl = request.cacheControl().toString();
//            return originalResponse.newBuilder().header("Cache-Control", cacheControl)
//                    .removeHeader("Pragma").build();
//        } else {
//            return originalResponse.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG)
//                    .removeHeader("Pragma").build();
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubService service = RetrofitHelper.getRetrofit().create(GitHubService.class);

        btnGetData = findViewById(R.id.btnGetData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> headers = new HashMap<>();
                headers.put("token", "1234");
                headers.put("id", 143326);

                HashMap<String, Object> queries = new HashMap<>();
                queries.put("token", "1234");
                queries.put("repoId", 143326);
                queries.put("testId", 143326);

                Observable<List<Repo>> repos = service.listRepos("octocat", headers);

                repos.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Observer<List<Repo>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(List<Repo> repos) {
                                Log.d("testing", repos.get(0).getId()+"");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("testing", "show Error");
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });

//        Call<List<Repo>> repos = service.listRepos("octocat");

//        repos.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                List<Repo> repoList = response.body();
//                Log.d("testing", repoList.get(0).getId()+"");
//            }
//
//            // this will be called if there is a network failure, like no internet
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                Log.d("testing", " get data failed");
//            }
//        });
    }
}