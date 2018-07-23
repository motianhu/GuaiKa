package com.smona.app.guaika.more.presenter;

import com.smona.app.guaika.home.presenter.VideoPresenter;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.more.factory.CategoryRetrofitFactory;

import rx.Observable;

public class MorePresenter extends AbsMorePresenter {
    private static final int PAGE_SIZE = 20;

    @Override
    public Observable<String> getHttpCallObservable(int curPage) {
        int offset = (curPage - 1) * PAGE_SIZE;
        return CategoryRetrofitFactory.getCatgoryService().getVideos(PAGE_SIZE, offset);
    }

    @Override
    public DataType getType() {
        return DataType.CATEGORY;
    }
}
