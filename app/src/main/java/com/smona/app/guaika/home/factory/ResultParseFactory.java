package com.smona.app.guaika.home.factory;

import android.util.Log;

import com.smona.app.guaika.category.http.parse.CategoryResultParse;
import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.home.http.parse.HomeResultParse;
import com.smona.app.guaika.home.http.parse.ResultParse;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultParseFactory {

    public static ResultParse create(DataType type) {
        ResultParse parse = null;
        switch (type) {
            case HOME:
                parse = new HomeResultParse();
                break;
            case CATEGORY:
                parse = new CategoryResultParse();
                break;
        }
        return parse;
    }

    public static List<VideoData> parse(String value, DataType type) {
        try {
            JSONObject json = new JSONObject(value);
            ResultParse parse = create(type);
            return parse.parse(json);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(0);
        }
    }
}
