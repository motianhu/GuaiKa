package com.smona.app.guaika.category.presenter;

import com.smona.app.guaika.category.factory.CategoryRetrofitFactory;
import com.smona.app.guaika.home.presenter.VideoPresenter;
import com.smona.app.guaika.main.http.DataType;

import rx.Observable;

public class CategoryPresenter extends VideoPresenter {
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
