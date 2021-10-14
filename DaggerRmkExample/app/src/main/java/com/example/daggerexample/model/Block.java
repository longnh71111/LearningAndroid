package com.example.daggerexample.model;

import javax.inject.Inject;

import lombok.Data;

@Data
public class Block {
    public BlockLevel2 blockLevel2;

    @Inject
    public Block(BlockLevel2 blockLevel2) {
        this.blockLevel2 = blockLevel2;
    }
}
