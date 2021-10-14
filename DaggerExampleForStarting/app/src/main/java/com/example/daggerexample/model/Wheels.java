package com.example.daggerexample.model;

import javax.inject.Inject;

import lombok.Data;


public class Wheels {
    public Rims rims;
    public Tires tires;

    public Wheels(Tires tires, Rims rims) {
        this.rims = rims;
        this.tires = tires;
    }
}
