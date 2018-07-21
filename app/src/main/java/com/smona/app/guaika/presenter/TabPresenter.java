package com.smona.app.guaika.presenter;

import com.smona.app.guaika.http.DataType;

public class TabPresenter extends VideoTabPresenter {

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}
