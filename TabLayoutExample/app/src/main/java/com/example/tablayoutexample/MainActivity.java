package com.example.tablayoutexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tablayoutexample.adapter.BlankPageAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sliding_tabs)
    SlidingTabLayout slidingTabs;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    List<String> mTitles = new ArrayList<>();
    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mTitles.add("Tab1");
//        mTitles.add("Tab2");
//        mFragments.add(new Blank1Fragment());
//        mFragments.add(new Blank2Fragment());
        for (int i = 0; i < 10; i++) {
            mTitles.add("Tab "+i);
            mFragments.add(new Blank1Fragment());
        }
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new BlankPageAdapter(getSupportFragmentManager(), mTitles, mFragments));
        slidingTabs.setViewPager(mViewPager);
    }
}