package com.example.daggerexample.module;

import com.example.daggerexample.model.Driver;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {

    @Provides
    Driver provideDriver() {
        return new Driver();
    }
}
