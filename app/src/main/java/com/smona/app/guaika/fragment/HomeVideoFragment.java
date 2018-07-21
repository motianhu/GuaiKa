package com.smona.app.guaika.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.smona.app.guaika.HomeActivity;
import com.smona.app.guaika.R;
import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.factory.FragmentFactory;
import com.smona.app.guaika.presenter.HomeVideoPresenter;
import com.smona.app.guaika.presenter.VideoPresenter;

public class HomeVideoFragment extends VideoFragment {
    private TabData mType;

    @Override
    public View getContentView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        mType = (TabData)getArguments().getSerializable(FragmentFactory.KEY_BUNDLE_TAB_ITEM);
        return super.getContentView(inflater, savedInstanceState);
    }

    @Override
    public VideoPresenter createPresenter() {
        return new HomeVideoPresenter(mType);
    }

    @Override
    public int getName() {
        return R.string.app_name;
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
