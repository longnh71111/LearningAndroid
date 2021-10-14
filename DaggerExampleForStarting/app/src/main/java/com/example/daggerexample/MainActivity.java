package com.example.daggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;




import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.model.Rims;
import com.example.daggerexample.model.Tires;
import com.example.daggerexample.model.Wheels;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tires tires = new Tires();
        Rims rims = new Rims();
        Wheels wheels = new Wheels(tires, rims);
        Engine engine = new Engine();
        Car car = new Car(engine, wheels);
        car.drive();
    }

}