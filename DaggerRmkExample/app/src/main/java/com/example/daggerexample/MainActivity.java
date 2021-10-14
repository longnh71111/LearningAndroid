package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.daggerexample.component.CarComponent;


import com.example.daggerexample.component.DaggerDriverComponent;
import com.example.daggerexample.model.AudiEngine;
import com.example.daggerexample.model.Block;
import com.example.daggerexample.model.BlockLevel2;
import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.DieselEngine;
import com.example.daggerexample.model.Driver;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.model.PetrolEngine;
import com.example.daggerexample.model.Remote;
import com.example.daggerexample.module.DieselEngineModule;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2, car3;
    @Inject
    Remote remote;

    @Inject
    Block block;

    private TextView btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        initView();
//
//        Tires tires = new Tires();
//        Rims rims = new Rims();
//        Wheels wheels = new Wheels(tires, rims);
//        Engine engine = new Engine();
//        Car car = new Car(engine, wheels);
        CarComponent carComponent = DaggerDriverComponent.builder().
                build().getCarComponentFactory().createComponent(1,2,3);


//        CarComponent carComponent = DaggerCarComponent.builder()
//                .setDriverComponent(DaggerDriverComponent.create()).setPower(150).setCapacity(100).build();
        carComponent.inject(this);
//        car.enableRemote(remote);
//        dieselEngine.startEngine();
        car1.getEngine().startEngine();
        car1.setEngine(new DieselEngine(4,5));
        car2.setEngine(new PetrolEngine(6));
        block.setBlockLevel2(new BlockLevel2(123));
        car3.setEngine(new AudiEngine(block));
        car1.getEngine().startEngine();
        car2.getEngine().startEngine();
        car3.getEngine().startEngine();
//        driver.testDriver();
//        driver.testDriver();

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });

        Driver driver = new Driver();
        carComponent.inject(driver);
        driver.testDriver();
    }

    private void initView() {
        btnTest = findViewById(R.id.btnTest);
    }
}