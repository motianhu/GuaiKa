package com.smona.app.guaika.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.smona.app.guaika.R;
import com.smona.app.guaika.main.bean.TabData;
import com.smona.app.guaika.home.factory.FragmentFactory;
import com.smona.app.guaika.home.presenter.HomeVideoPresenter;
import com.smona.app.guaika.home.presenter.VideoPresenter;

public class HomeFragment extends VideoFragment {
    private TabData mType;

    @Override
    public View getContentView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        mType = (TabData) getArguments().getSerializable(FragmentFactory.KEY_BUNDLE_TAB_ITEM);
        return super.getContentView(inflater, savedInstanceState);
    }

    @Override
    public VideoPresenter createPresenter() {
        return new HomeVideoPresenter(mType);
    }

    @Override
    public int getName() {
        return R.string.home_fragment;
    }

    @Override
    public boolean isInitRefreshEnable() {
        return false;
    }

    @Override
    public boolean isDelayRefreshEnable() {
        return true;
    }
}
