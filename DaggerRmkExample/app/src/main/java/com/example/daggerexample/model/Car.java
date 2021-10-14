package com.example.daggerexample.model;



import android.util.Log;

import com.example.daggerexample.component.CarComponent;


import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Data;

@Data
public class Car {
    public Engine engine;
    public Wheels wheels;

    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
//

    public void enableRemote(Remote remote) {
        remote.logInsideRemote();
    }

    public void drive() {
        Log.d("testing", " on drives " + this);
    }

}
