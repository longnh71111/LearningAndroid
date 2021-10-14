package com.example.recyclerviewhelperexample.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.recyclerviewhelperexample.R;
import com.example.recyclerviewhelperexample.model.Status;
import com.example.recyclerviewhelperexample.utils.ClickableMovementMethod;
import com.example.recyclerviewhelperexample.utils.DataServer;
import com.example.recyclerviewhelperexample.utils.SpannableStringUtils;
import com.example.recyclerviewhelperexample.utils.Tips;

public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {

    public AnimationAdapter() {
        super(R.layout.item_animation, DataServer.getSampleData(100));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Status item) {
        switch (holder.getLayoutPosition() % 3) {
            case 0:
                holder.setImageResource(R.id.img, R.drawable.animation_img1);
                break;
            case 1:
                holder.setImageResource(R.id.img, R.drawable.animation_img2);
                break;
            case 2:
                holder.setImageResource(R.id.img, R.drawable.animation_img3);
                break;
            default:
                break;
        }
        holder.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        TextView tweetText = holder.getView(R.id.tweetText);
        tweetText.setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        tweetText.setMovementMethod(ClickableMovementMethod.getInstance());
        tweetText.setFocusable(false);
        tweetText.setClickable(false);
        tweetText.setLongClickable(false);
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(@NonNull View widget) {
            Tips.show("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}

