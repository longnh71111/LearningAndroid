package com.example.retrofit2example;

import com.example.retrofit2example.api.GitHubService;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 20 * 1000;
    //写入时间
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20 * 1000;
    //超时时间
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20 * 1000;
    //最大缓存
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 20 * 1024 * 1024;//设置20M

    public static Retrofit getRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //包含header、body数据
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//                .cache(getCache(this))//设置缓存
                // 失败重发
                .retryOnConnectionFailure(true)
                //设置缓存
//                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())
//                //http数据log，日志中打印出HTTP请求&响应数据
                .addInterceptor(loggingInterceptor)
//                //便于查看json
                //.addInterceptor(new LoggerInterceptor())
//                .addInterceptor(new UserAgentInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();



        return  retrofit;
    }

}
