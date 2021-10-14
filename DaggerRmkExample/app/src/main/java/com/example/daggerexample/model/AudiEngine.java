package com.example.daggerexample.model;

import android.util.Log;

import javax.inject.Inject;

import lombok.Data;

@Data
public class AudiEngine implements Engine {
    public Block block;

    @Inject
    public AudiEngine(Block block) {
        this.block = block;
    }

    @Override
    public void startEngine() {
        Log.d("testing", "block level: "+block.getBlockLevel2().getLevel());
    }
}
