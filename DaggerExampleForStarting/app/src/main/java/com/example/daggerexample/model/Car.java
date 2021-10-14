package com.example.daggerexample.model;



import android.util.Log;


import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Data;


public class Car {
    public Engine engine;
    public Wheels wheels;

    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        Log.d("testing", "on drives");
    }
}
