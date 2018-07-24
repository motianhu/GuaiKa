package com.smona.app.guaika.video.fragment;

import com.smona.app.guaika.R;
import com.smona.app.guaika.video.presenter.AbsRecommendPresenter;
import com.smona.app.guaika.video.presenter.RecommendPresenter;

public class RecommendFragment extends AbsRecommendFragment {
    @Override
    public AbsRecommendPresenter createPresenter() {
        return new RecommendPresenter();
    }

    @Override
    public int getName() {
        return R.string.category_fragment;
    }
}
