package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.daggerexample.component.CarComponent;
import com.example.daggerexample.component.DaggerDriverComponent;
import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.Engine;

import javax.inject.Inject;

public class TestActivity extends AppCompatActivity {
    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        CarComponent carComponent = DaggerDriverComponent.builder().
                build().getCarComponentFactory().createComponent(1,2,3);


//        CarComponent carComponent = DaggerCarComponent.builder()
//                .setDriverComponent(DaggerDriverComponent.create()).setPower(150).setCapacity(100).build();
        carComponent.inject(this);

        car.getEngine().startEngine();
    }

}