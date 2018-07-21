package com.smona.app.guaika.presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.mvpview.VideoTabMvpView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public abstract class VideoTabPresenter extends MvpBasePresenter<VideoTabMvpView> implements TypePresenter {

    public void queryVideoTab(final boolean pullToRefresh) {
        Observable.just(getType().value())
                .subscribeOn(Schedulers.io())
                .map(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return true;
                    }
                })
                .flatMap(new Func1<Boolean, Observable<List<TabData>>>() {
                    @Override
                    public Observable<List<TabData>> call(Boolean aBoolean) {
                        List<TabData> tabs = TabData.createTabDatas();
                        return Observable.just(tabs);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<TabData>>() {
                    @Override
                    public void onCompleted() {
                        getView().showContent();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e, pullToRefresh);
                    }

                    @Override
                    public void onNext(List<TabData> tabs) {
                        if (isViewAttached()) {
                            getView().setData(tabs);
                        }
                    }
                });
    }
}
