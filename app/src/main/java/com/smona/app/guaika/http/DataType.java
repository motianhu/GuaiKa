package com.smona.app.guaika.http;

public enum DataType {
    HOME(1), CATEGORY(2);

    int mValue;
    DataType(int value) {
        mValue = value;
    }

    public int value() {
        return mValue;
    }
}
