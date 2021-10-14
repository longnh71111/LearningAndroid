package com.example.rxjava2example;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
