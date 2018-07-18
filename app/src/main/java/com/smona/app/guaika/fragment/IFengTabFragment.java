package com.smona.app.guaika.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.presenter.IFengTabPresenter;
import com.smona.app.guaika.presenter.VideoTabPresenter;

public class IFengTabFragment extends BaseTabFragment {

    @Override
    public VideoTabPresenter createPresenter() {

        return new IFengTabPresenter();
    }

    @Override
    public int getName() {
        return R.string.app_name;
    }
}
