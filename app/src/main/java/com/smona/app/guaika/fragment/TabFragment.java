package com.smona.app.guaika.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.presenter.TabPresenter;
import com.smona.app.guaika.presenter.VideoTabPresenter;

public class TabFragment extends BaseTabFragment {

    @Override
    public VideoTabPresenter createPresenter() {
        return new TabPresenter();
    }

    @Override
    public int getName() {
        return R.string.app_name;
    }
}
