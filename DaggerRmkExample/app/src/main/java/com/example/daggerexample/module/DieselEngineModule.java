package com.example.daggerexample.module;

import com.example.daggerexample.model.BlockLevel2;
import com.example.daggerexample.model.DieselEngine;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Named;

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
    public DieselEngine provideDieselEngine() {
        return new DieselEngine(200, 80);
    }

    @Provides
    public BlockLevel2 provideBlockLevel() {
        return new BlockLevel2(36);
    }

    @Provides
    @Named("foo") int provideFoo() {
        return 400;
    }

    @Provides
    @Named("bar") int provideBar() {
        return 347;
    }
}
