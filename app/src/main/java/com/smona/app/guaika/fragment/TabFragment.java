package com.smona.app.guaika.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.presenter.HomeTabPresenter;
import com.smona.app.guaika.presenter.VideoTabPresenter;

public class TabFragment extends BaseTabFragment {

    @Override
    public VideoTabPresenter createPresenter() {
        return new HomeTabPresenter();
    }

    @Override
    public int getName() {
        return R.string.app_name;
    }
}
