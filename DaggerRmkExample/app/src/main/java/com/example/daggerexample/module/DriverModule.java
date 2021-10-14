package com.example.daggerexample.module;

import com.example.daggerexample.model.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {


    @Provides
    @Singleton
    Driver provideDriver() {
        return new Driver();
    }
}
