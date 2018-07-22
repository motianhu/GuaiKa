package com.smona.app.guaika.category.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.category.presenter.CategoryPresenter;
import com.smona.app.guaika.home.fragment.VideoFragment;
import com.smona.app.guaika.home.presenter.VideoPresenter;

public class CategoryFragment extends VideoFragment {
    @Override
    public VideoPresenter createPresenter() {
        return new CategoryPresenter();
    }

    @Override
    public int getName() {
        return R.string.category_fragment;
    }
}
