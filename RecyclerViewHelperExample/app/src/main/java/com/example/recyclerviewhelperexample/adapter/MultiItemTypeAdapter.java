package com.example.recyclerviewhelperexample.adapter;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.recyclerviewhelperexample.R;
import com.example.recyclerviewhelperexample.model.ClickEntity;
import com.example.recyclerviewhelperexample.utils.DataServer;
import com.example.recyclerviewhelperexample.utils.Tips;

import java.util.List;

public class MultiItemTypeAdapter extends BaseMultiItemQuickAdapter<ClickEntity, BaseViewHolder> implements OnItemClickListener, OnItemChildClickListener {
    public static final int CLICK_ITEM_VIEW = 1;
    public static final int CLICK_ITEM_CHILD_VIEW = 2;
    public static final int LONG_CLICK_ITEM_VIEW = 3;
    public static final int LONG_CLICK_ITEM_CHILD_VIEW = 4;
    public static final int NEST_CLICK_ITEM_CHILD_VIEW = 5;

    public MultiItemTypeAdapter(List<ClickEntity> data) {
        super(data);
        addItemType(CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);

        addChildClickViewIds(R.id.btn,
                R.id.iv_num_reduce, R.id.iv_num_add,
                R.id.item_click);

        addChildLongClickViewIds(R.id.iv_num_reduce, R.id.iv_num_add,
                R.id.btn);
    }


    @Override
    protected void convert(@NonNull final BaseViewHolder helper, final ClickEntity item) {
        switch (helper.getItemViewType()) {
            case CLICK_ITEM_VIEW:

                break;
            case CLICK_ITEM_CHILD_VIEW:
                // set img data
                Log.d("testing", helper.getAdapterPosition()+"");
                RecyclerView rvInside = helper.getView(R.id.rvInside);
                rvInside.setHasFixedSize(true);

                if (rvInside.getLayoutManager() == null) {
                    rvInside.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                }
                if (rvInside.getAdapter() == null) {
                    ItemChildViewAdapter itemChildViewAdapter = new ItemChildViewAdapter(item.getStatusList());
                    itemChildViewAdapter.setOnItemClickListener(this);
                    itemChildViewAdapter.setOnItemChildClickListener(this);
                    rvInside.setAdapter(itemChildViewAdapter);
                }

                break;
            case LONG_CLICK_ITEM_VIEW:

                break;
            case LONG_CLICK_ITEM_CHILD_VIEW:

                break;
            case NEST_CLICK_ITEM_CHILD_VIEW:
                // u can set nestview id
                RecyclerView recyclerView = helper.getView(R.id.nest_list);
                recyclerView.setHasFixedSize(true);

                if (recyclerView.getLayoutManager() == null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                }
                if (recyclerView.getAdapter() == null) {
                    NestAdapter nestAdapter = new NestAdapter();
                    nestAdapter.setOnItemClickListener(this);
                    nestAdapter.setOnItemChildClickListener(this);
                    recyclerView.setAdapter(nestAdapter);
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Tips.show("childView click");
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Tips.show("嵌套RecycleView item 收到: " + "点击了第 " + position + " 一次");
    }
}
