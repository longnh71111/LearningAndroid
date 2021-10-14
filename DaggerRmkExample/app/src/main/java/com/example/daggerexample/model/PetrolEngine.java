package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {
    int hPower;

    @Inject
    public PetrolEngine(@Named("horsePower") int hPower) {
        this.hPower = hPower;
    }

    @Override
    public void startEngine() {
        Log.d("testing", " start Petrol Engine: "+ hPower);
    }
}
