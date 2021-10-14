package com.example.recyclerviewhelperexample.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ClickEntity implements MultiItemEntity {
    public int Type;
    public List<Status> statusList = new ArrayList<>();



    public ClickEntity(final int type) {
        Type = type;
    }

    @Override
    public int getItemType() {
        return Type;
    }
}
