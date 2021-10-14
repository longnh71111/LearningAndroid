package com.example.daggerexample.component;

import com.example.daggerexample.model.Driver;
import com.example.daggerexample.module.DriverModule;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface DriverComponent {

    Driver getDriver();

//    CarComponent getCarComponent();

    CarComponent.Factory getCarComponentFactory();
}
