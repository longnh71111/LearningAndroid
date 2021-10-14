package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class DieselEngine implements Engine {
    int hPower;
    int capacity;
//
    @Inject
    public DieselEngine(@Named("horsePower") int hPower, @Named("capacity")int capacity) {
        this.hPower = hPower;
        this.capacity = capacity;
    }

//    @Inject
//    public DieselEngine(int hPower, String capacity) {
//        this.hPower = hPower;
//        this.capacity = capacity;
//    }

    @Override
    public void startEngine() {
        Log.d("testing", " start Diesel Enginee with horsePower: "+ hPower);
        Log.d("testing", " start Diesel Enginee with capacity: "+capacity);
    }
}
