package com.smona.app.guaika.main.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.main.presenter.TabPresenter;
import com.smona.app.guaika.main.presenter.VideoTabPresenter;

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
