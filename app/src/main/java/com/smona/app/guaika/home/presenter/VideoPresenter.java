package com.smona.app.guaika.home.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.home.factory.ResultParseFactory;
import com.smona.app.guaika.home.mvpview.VideoMvpView;
import com.smona.app.guaika.main.presenter.TypePresenter;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public abstract class VideoPresenter extends MvpBasePresenter<VideoMvpView>
        implements TypePresenter {

    private int mCurPage = 1;

    public void refreshData(boolean pullToRefresh) {
        mCurPage = 1;
        request(false, pullToRefresh);
    }

    public void loadMoreData() {
        request(true, false);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        mCurPage = 1;
    }

    public abstract Observable<String> getHttpCallObservable(int curPage);

    private void request(final boolean loadMore, final boolean pullToRefresh) {
        getHttpCallObservable(mCurPage)
                .subscribeOn(Schedulers.io())
                .map(new Func1<String, List<VideoData>>() {
                    @Override
                    public List<VideoData> call(String s) {
                        return ResultParseFactory.parse(s, getType());
                    }
                })
                .flatMap(new Func1<List<VideoData>, Observable<List<VideoData>>>() {
                    @Override
                    public Observable<List<VideoData>> call(List<VideoData> videos) {
                        if (videos == null || videos.size() == 0) {
                            return Observable.error(new NullPointerException("not load video data"));
                        }
                        return Observable.just(videos);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<VideoData>>() {
                    @Override
                    public void onCompleted() {
                        getView().showContent();
                        mCurPage++;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (loadMore) {
                            getView().showLoadMoreErrorView();
                        } else {
                            getView().showError(e, pullToRefresh);
                        }
                    }

                    @Override
                    public void onNext(List<VideoData> videos) {
                        if (isViewAttached()) {
                            if (loadMore) {
                                getView().setLoadMoreData(videos);
                            } else {
                                getView().setData(videos);
                            }
                        }
                    }
                });
    }
}
