package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.daggerexample.component.CarComponent;



//import com.example.daggerexample.component.DaggerCarComponent;

import com.example.daggerexample.component.DaggerDriverComponent;
import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.DieselEngine;
import com.example.daggerexample.model.Driver;
import com.example.daggerexample.model.Remote;
import com.example.daggerexample.scope.DieselV1Scope;
import com.example.daggerexample.scope.DieselV2Scope;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    @DieselV1Scope
    Car car1;
    @Inject
    @DieselV2Scope
    Car car2;
    @Inject
    Remote remote;

    @Inject
    DieselEngine dieselEngine;

    @Inject
    Driver driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Tires tires = new Tires();
//        Rims rims = new Rims();
//        Wheels wheels = new Wheels(tires, rims);
//        Engine engine = new Engine();
//        Car car = new Car(engine, wheels);
//        CarComponent carComponent = DaggerCarComponent.builder().setDriverComponent(DaggerDriverComponent.create()).setCapacity(50).setPower(50).build();
//        carComponent.inject(this);

        CarComponent carComponent = DaggerDriverComponent.
                builder().
                build().
                getCarComponentFactory().
                createx(40, 40);
        carComponent.inject(this);

//        ActivityComponent activityComponent = DaggerCarComponent.builder().setPower(150).setCapacity(100).build();
//        carComponent.inject(this);
//        car.enableRemote(remote);
//        dieselEngine.startEngine();
        car1.getEngine().startEngine();
        car2.getEngine().startEngine();

        Log.d("testing", driver.toString());

    }
}