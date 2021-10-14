package com.example.daggerexample.module;

import com.example.daggerexample.model.DieselEngine;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.scope.ActivityScope;
import com.example.daggerexample.scope.DieselV1Scope;
import com.example.daggerexample.scope.DieselV2Scope;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    @Provides
    @ActivityScope
    public Engine provideEngine(DieselEngine dieselEngine) {
        return dieselEngine;
    }

//    @Provides
//    public Engine providePetrolEngine(PetrolEngine petrolEngine) {
//        return petrolEngine;
//    }

    @Provides
    @DieselV1Scope
    public DieselEngine provideDieselEngineV1() {
        return new DieselEngine(200, 80);
    }
//
    @Provides
    @DieselV2Scope
    public DieselEngine provideDieselEngineV2() {
        return new DieselEngine(100, 40);
    }

}
