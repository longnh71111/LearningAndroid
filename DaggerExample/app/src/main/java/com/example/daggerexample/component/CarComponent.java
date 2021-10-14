package com.example.daggerexample.component;

import com.example.daggerexample.MainActivity;
import com.example.daggerexample.model.Car;
import com.example.daggerexample.module.CarModule;
import com.example.daggerexample.module.DieselEngineModule;
import com.example.daggerexample.scope.ActivityScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;


@ActivityScope
@Subcomponent(modules = {CarModule.class, DieselEngineModule.class})
public interface CarComponent {

    void inject(MainActivity mainActivity);

//    @Subcomponent.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder setPower(@Named("horsePower") int power);
//
//        @BindsInstance
//        Builder setCapacity(@Named("capacity") int capacity);
//
////        Builder setDriverComponent(DriverComponent driverComponent);
//
//        CarComponent build();
//    }

    @Subcomponent.Factory
    interface Factory {

        CarComponent createx(@BindsInstance @Named("horsePower") int power,
                            @BindsInstance  @Named("capacity") int capacity);
//        @BindsInstance
//        Builder setPower(@Named("horsePower") int power);
//
//        @BindsInstance
//        Builder setCapacity(@Named("capacity") int capacity);
//
////        Builder setDriverComponent(DriverComponent driverComponent);
//
//        CarComponent build();
    }
}
