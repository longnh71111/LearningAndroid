package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;


public class Driver {
//
//    @Inject
//    Car car;

    @Inject
    public Driver() {
    }

    public void testDriver() {
        Log.d("testing", " on test Driver " );
    }
}
