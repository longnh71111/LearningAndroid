package com.example.daggerexample.module;

import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.Driver;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.model.Remote;
import com.example.daggerexample.model.Rims;
import com.example.daggerexample.model.Tires;
import com.example.daggerexample.model.Wheels;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {

    @Provides
    public Car provideCar(Engine engine, Wheels wheels) {
        return new Car(engine, wheels);
    }


    @Provides
    public Wheels provideWheels(Tires tires, Rims rims) {
        return new Wheels(tires, rims);
    }

    @Provides
    @ActivityScope
    public Tires provideTires() {
        return new Tires();
    }

    @Provides
    public Rims provideRims() {
        return new Rims();
    }

    @Provides
    public Remote provideRemote() {
        return new Remote();
    }
}
