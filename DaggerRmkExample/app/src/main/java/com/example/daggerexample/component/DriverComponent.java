package com.example.daggerexample.component;

import com.example.daggerexample.MainActivity;
import com.example.daggerexample.model.Driver;
import com.example.daggerexample.module.DriverModule;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface DriverComponent {

//    CarComponent getCarComponent();
//    CarComponent.Builder getCarComponentBuilder();
    Driver getDriver();

    CarComponent.CarFactory getCarComponentFactory();


}
