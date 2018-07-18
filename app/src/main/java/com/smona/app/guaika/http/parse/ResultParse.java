package com.smona.app.guaika.http.parse;

import com.smona.app.guaika.bean.VideoData;
import com.smona.app.guaika.bean.VideoTabData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public interface ResultParse {

    List<VideoData> parse(JSONObject json) throws JSONException;

    List<VideoTabData> parseTab(JSONObject json) throws JSONException;
}
