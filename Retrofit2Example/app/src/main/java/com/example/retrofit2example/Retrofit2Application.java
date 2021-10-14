package com.example.retrofit2example;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class Retrofit2Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
