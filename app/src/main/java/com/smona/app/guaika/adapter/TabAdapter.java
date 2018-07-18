package com.smona.app.guaika.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smona.app.guaika.bean.VideoTabData;
import com.smona.app.guaika.factory.FragmentFactory;
import com.smona.app.guaika.http.DataType;

import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    private List<VideoTabData> mList;
    private DataType mType;

    public TabAdapter(FragmentManager fm, List<VideoTabData> list, DataType type) {

        super(fm);
        this.mList = list;
        this.mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createTabItemFragment(mType, getItemData(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return getItemData(position).getTabName();
    }

    @Override
    public int getCount() {

        return mList.size();
    }

    public VideoTabData getItemData(int position) {

        return mList.get(position);
    }
}
