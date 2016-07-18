package com.ddmeng.loopingfragmentpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentStatePagerAdapter {


    private List<String> dataList = null;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return MainActivity.NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        String title = dataList.get(position);
        return ArrayListFragment.newInstance(position, title);
    }


    public void setDataList(List<String> dataList) {
        this.dataList = new ArrayList<>(dataList);

        //add two more extra items to the data list
        this.dataList.add(0, dataList.get(dataList.size() - 1));
        this.dataList.add(this.dataList.size(), dataList.get(0));
    }

}
