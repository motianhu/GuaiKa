package com.smona.app.guaika.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.smona.app.guaika.R;
import com.smona.app.guaika.factory.FragmentFactory;
import com.smona.app.guaika.presenter.IFengVideoPresenter;
import com.smona.app.guaika.presenter.VideoPresenter;

public class IFengVideoFragment extends VideoFragment {
    private int mTabId;

    @Override
    public View getContentView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {

        mTabId = getArguments().getInt(FragmentFactory.KEY_BUNDLE_TAB_ID);
        return super.getContentView(inflater, savedInstanceState);
    }

    @Override
    public VideoPresenter createPresenter() {

        return new IFengVideoPresenter(mTabId);
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
