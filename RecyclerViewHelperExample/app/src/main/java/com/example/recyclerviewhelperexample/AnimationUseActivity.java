package com.example.recyclerviewhelperexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.recyclerviewhelperexample.adapter.AnimationAdapter;
import com.example.recyclerviewhelperexample.adapter.NormalRvAdapter;
import com.example.recyclerviewhelperexample.listener.DiffDemoCallback;
import com.example.recyclerviewhelperexample.listener.OnNormalItemClickListener;
import com.example.recyclerviewhelperexample.model.DiffUtilDemoEntity;
import com.example.recyclerviewhelperexample.model.Status;
import com.example.recyclerviewhelperexample.utils.DataServer;
import com.example.recyclerviewhelperexample.utils.Tips;
import com.example.recyclerviewhelperexample.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationUseActivity extends AppCompatActivity {


    @BindView(R.id.rv_list)
    public RecyclerView rvList;
    @BindView(R.id.item_change_btn)
    public Button itemChangeBtn;
    @BindView(R.id.notify_change_btn)
    public Button notifyChangeBtn;
    private AnimationAdapter mAnimationAdapter;
    private NormalRvAdapter normalRvAdapter;
    private List<Status> statusList = new ArrayList<>();

    OnNormalItemClickListener listener = new OnNormalItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (view.getId()) {
                case R.id.tweetName:
                    Log.d("testing", "click vao tweetName");
                    break;
                case 1:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_use);
        ButterKnife.bind(this);
        Utils.init(this);

        // lay data tren server = rxjava 2 va retrofit
        statusList = DataServer.getSampleData(100);

        mAnimationAdapter = new AnimationAdapter();
//        normalRvAdapter =  new NormalRvAdapter(this, statusList, listener);
        mAnimationAdapter.setAnimationEnable(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);

        mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInBottom);
        mAnimationAdapter.addChildClickViewIds(R.id.img, R.id.tweetName, R.id.tweetText);
        mAnimationAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.img:
                        content = "img:" + status.getUserAvatar();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        break;
                    case R.id.tweetText:
                        content = "tweetText:" + status.getUserName();
                        break;
                    default:
                        break;
                }
                Tips.show(content);
            }
        });

        rvList.setAdapter(mAnimationAdapter);

        mAnimationAdapter.setDiffCallback(new DiffDemoCallback());

//        mAnimationAdapter.notifyDataSetChanged();
//        rvList.setAdapter(normalRvAdapter);
//        normalRvAdapter.notifyDataSetChanged();
    }



}