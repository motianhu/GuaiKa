package com.smona.app.guaika.video.presenter;

import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.video.factory.RecommendRetrofitFactory;

import rx.Observable;

public class RecommendPresenter extends AbsRecommendPresenter {
    private static final int PAGE_SIZE = 20;

    @Override
    public Observable<String> getHttpCallObservable(int curPage) {
        int offset = (curPage - 1) * PAGE_SIZE;
        return RecommendRetrofitFactory.getCatgoryService().getVideos(PAGE_SIZE, offset);
    }

    @Override
    public DataType getType() {
        return DataType.CATEGORY;
    }
}
