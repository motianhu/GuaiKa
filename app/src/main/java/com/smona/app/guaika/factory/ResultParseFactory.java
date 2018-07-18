package com.smona.app.guaika.factory;

import com.smona.app.guaika.bean.VideoData;
import com.smona.app.guaika.bean.VideoTabData;
import com.smona.app.guaika.http.DataType;
import com.smona.app.guaika.http.parse.IFengTabResultParse;
import com.smona.app.guaika.http.parse.ResultParse;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultParseFactory {

    public static ResultParse create(DataType type) {

        ResultParse parse = null;
        switch (type) {
            case IFENG:
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
        } catch(Exception e) {
            return new ArrayList<>(0);
        }
    }

    public static List<VideoTabData> parseTab(String value, DataType type) {

        try {
            JSONObject json = new JSONObject(value);
            ResultParse parse = create(type);
            return parse.parseTab(json);
        } catch(Exception e) {
            return new ArrayList<>(0);
        }
    }
}
