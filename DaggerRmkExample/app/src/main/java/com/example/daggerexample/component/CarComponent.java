package com.example.daggerexample.component;

import com.example.daggerexample.MainActivity;
import com.example.daggerexample.TestActivity;
import com.example.daggerexample.model.Car;
import com.example.daggerexample.model.Driver;
import com.example.daggerexample.model.Engine;
import com.example.daggerexample.module.CarModule;
import com.example.daggerexample.module.DieselEngineModule;
import com.example.daggerexample.module.PetrolEngineModule;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;


@ActivityScope
@Subcomponent(modules = {CarModule.class, DieselEngineModule.class, PetrolEngineModule.class})
public interface CarComponent {
    void inject(MainActivity mainActivity);
    void inject(TestActivity testActivity);
    void inject(Driver driver);
//    Car getCar();
//    @Subcomponent.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder setPower(@Named("horsePower") int power);
//
//        @BindsInstance
//        Builder setCapacity(@Named("capacity") int capacity);
//
////        @BindsInstance
////        Builder getCarModule(CarModule carModule);
////
////        @BindsInstance//
////     Builder getDieselEngineModule(DieselEngineModule dieselEngineModule);
//
//
////        Builder setDriverComponent(DriverComponent driverComponent);
//
//
//        CarComponent build();
//    }

    @Subcomponent.Factory
    interface CarFactory {

        CarComponent createComponent(@BindsInstance @Named("horsePower") int power,
                                     @BindsInstance @Named("capacity") int capacity,
                                     @BindsInstance @Named("level") int level);


    }

}
