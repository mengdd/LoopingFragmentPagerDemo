package com.ddmeng.loopingfragmentpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    static final int NUM_ITEMS = 10;

    MyAdapter mAdapter;

    @BindView(R.id.pager)
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new MyAdapter(getSupportFragmentManager());

        ButterKnife.bind(this);
        mPager.setAdapter(mAdapter);

    }

    @OnClick(R.id.goto_first)
    void goToFirstPage() {
        mPager.setCurrentItem(0);
    }

    @OnClick(R.id.goto_last)
    void goToLastPage() {
        mPager.setCurrentItem(NUM_ITEMS - 1);
    }
}
