package com.example.recyclerviewhelperexample.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.recyclerviewhelperexample.R;
import com.example.recyclerviewhelperexample.model.Status;
import com.example.recyclerviewhelperexample.utils.DataServer;
import com.example.recyclerviewhelperexample.utils.SpannableStringUtils;
import com.example.recyclerviewhelperexample.utils.Tips;
import com.example.recyclerviewhelperexample.utils.Utils;

class NestAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public NestAdapter() {
        super(R.layout.layout_nest_item, DataServer.getSampleData(20));
        addChildClickViewIds(R.id.tweetText);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition() % 3) {
            case 0:
                helper.setImageResource(R.id.img, R.drawable.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.drawable.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.drawable.animation_img3);
                break;
            default:
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            Tips.show("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
