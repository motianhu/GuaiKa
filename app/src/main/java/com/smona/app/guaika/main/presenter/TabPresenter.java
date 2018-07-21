package com.smona.app.guaika.main.presenter;

import com.smona.app.guaika.main.http.DataType;

public class TabPresenter extends VideoTabPresenter {

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}
