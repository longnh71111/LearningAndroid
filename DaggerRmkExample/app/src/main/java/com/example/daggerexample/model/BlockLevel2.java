package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Data;

@Data
public class BlockLevel2 {
    public int level;

    @Inject
    public BlockLevel2(int level) {
        this.level = level;
    }

    public void start() {
        Log.d("tesing", " block level: " + level);
    }
}
