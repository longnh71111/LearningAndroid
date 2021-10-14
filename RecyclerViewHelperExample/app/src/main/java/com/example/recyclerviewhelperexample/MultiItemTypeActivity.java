package com.example.recyclerviewhelperexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhelperexample.adapter.MultiItemTypeAdapter;
import com.example.recyclerviewhelperexample.model.ClickEntity;
import com.example.recyclerviewhelperexample.model.Status;
import com.example.recyclerviewhelperexample.utils.DataServer;
import com.example.recyclerviewhelperexample.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultiItemTypeActivity extends AppCompatActivity {

    MultiItemTypeAdapter mAdapter;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item_type);
        Utils.init(this);
        ButterKnife.bind(this);

        List<ClickEntity> data = new ArrayList<>();
        List<Status> statusList = DataServer.getSampleData(5);
        data.add(new ClickEntity(MultiItemTypeAdapter.CLICK_ITEM_VIEW));
        data.add(new ClickEntity(MultiItemTypeAdapter.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(MultiItemTypeAdapter.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickEntity(MultiItemTypeAdapter.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(MultiItemTypeAdapter.NEST_CLICK_ITEM_CHILD_VIEW));
        data.get(0).setStatusList(statusList);
        mAdapter = new MultiItemTypeAdapter(data);

        rvList.setHasFixedSize(true);
        rvList.setNestedScrollingEnabled(false);
        LinearLayoutManager lnManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(lnManager);
        rvList.setAdapter(mAdapter);
    }
}