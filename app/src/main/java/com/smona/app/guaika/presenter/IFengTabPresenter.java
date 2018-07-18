package com.smona.app.guaika.presenter;

import com.smona.app.guaika.factory.RetrofitFactory;
import com.smona.app.guaika.http.DataType;

import rx.Observable;

public class IFengTabPresenter extends VideoTabPresenter {

    @Override
    public Observable<String> getHttpCallObservable() {

        return RetrofitFactory.getIFengVideoService().getTabs();
    }

    @Override
    public DataType getType() {
        return DataType.IFENG;
    }
}
