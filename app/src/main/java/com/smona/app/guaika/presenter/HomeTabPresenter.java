package com.smona.app.guaika.presenter;

import com.smona.app.guaika.factory.RetrofitFactory;
import com.smona.app.guaika.http.DataType;

import rx.Observable;

public class HomeTabPresenter extends VideoTabPresenter {

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}
