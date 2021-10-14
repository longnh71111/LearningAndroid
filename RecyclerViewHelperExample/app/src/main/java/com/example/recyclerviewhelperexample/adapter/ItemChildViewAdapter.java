package com.example.recyclerviewhelperexample.adapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.recyclerviewhelperexample.R;
import com.example.recyclerviewhelperexample.model.Status;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemChildViewAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.iv_num_reduce)
    ImageView ivNumReduce;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.iv_num_add)
    ImageView ivNumAdd;
    @BindView(R.id.layout_num)
    LinearLayout layoutNum;
    @BindView(R.id.card_view)
    RelativeLayout cardView;

    public ItemChildViewAdapter(List<Status> dataList) {
        super(R.layout.item_childview_inside, dataList);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Status status) {
        ButterKnife.bind(this, holder.itemView);
        tv.setText(status.getText());
    }
}
