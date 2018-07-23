package com.smona.app.guaika.more.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.more.presenter.AbsMorePresenter;
import com.smona.app.guaika.more.presenter.MorePresenter;

public class MoreFragment extends AbsMoreFragment {
    @Override
    public AbsMorePresenter createPresenter() {
        return new MorePresenter();
    }

    @Override
    public int getName() {
        return R.string.category_fragment;
    }
}
