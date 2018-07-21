package com.smona.app.guaika.http.parse;

import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.bean.VideoData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface ResultParse {

    List<VideoData> parse(JSONObject json) throws JSONException;

    List<TabData> parseTab(JSONObject json) throws JSONException;
}
