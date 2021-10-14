package com.example.daggerexample.module;

import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.DieselEngine;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.model.Remote;
import com.example.daggerexample.model.Rims;
import com.example.daggerexample.model.Tires;
import com.example.daggerexample.model.Wheels;
import com.example.daggerexample.scope.ActivityScope;
import com.example.daggerexample.scope.DieselV1Scope;
import com.example.daggerexample.scope.DieselV2Scope;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {

    @Provides
    @DieselV1Scope
    public Car provideCar1(@DieselV1Scope DieselEngine engine, Wheels wheels) {
        return new Car(engine, wheels);
    }

    @Provides
    @DieselV2Scope
    public Car provideCar2(@DieselV2Scope DieselEngine engine, Wheels wheels) {
        return new Car(engine, wheels);
    }

    @Provides
    public Car provideCar(DieselEngine engine, Wheels wheels) {
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
