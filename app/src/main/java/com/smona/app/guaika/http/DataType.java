package com.smona.app.guaika.http;

public enum DataType {
    IFENG(4);

    int mValue;

    DataType(int value) {
        mValue = value;
    }

    public int value() {
        return mValue;
    }
}
