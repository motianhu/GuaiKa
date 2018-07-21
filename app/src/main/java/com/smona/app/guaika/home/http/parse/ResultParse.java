package com.smona.app.guaika.home.http.parse;

import com.smona.app.guaika.home.bean.VideoData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface ResultParse {
    List<VideoData> parse(JSONObject json) throws JSONException;
}
