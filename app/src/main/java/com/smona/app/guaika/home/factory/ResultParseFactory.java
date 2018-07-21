package com.smona.app.guaika.home.factory;

import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.home.http.parse.IFengTabResultParse;
import com.smona.app.guaika.home.http.parse.ResultParse;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultParseFactory {

    public static ResultParse create(DataType type) {
        ResultParse parse = null;
        switch (type) {
            case HOME:
                parse = new IFengTabResultParse();
                break;
            case CATEGORY:
                parse = new IFengTabResultParse();
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
            return new ArrayList<>(0);
        }
    }
}
