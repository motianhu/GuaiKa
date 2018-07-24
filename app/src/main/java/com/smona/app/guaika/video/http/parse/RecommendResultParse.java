package com.smona.app.guaika.video.http.parse;

import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.home.http.parse.ResultParse;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecommendResultParse implements ResultParse {
    private static final String KEY_VIDEO_LIST = "视频";
    private static final String KEY_ID = "vid";
    private static final String KEY_IMAGE = "cover";
    private static final String KEY_TITLE = "title";
    private static final String KEY_VIDEO_URL = "mp4_url";
    private static final String KEY_DURATION = "playCount";

    @Override
    public List<VideoData> parse(JSONObject json) throws JSONException {

        List<VideoData> list = new ArrayList<>();

        JSONArray videos = json.getJSONArray(KEY_VIDEO_LIST);
        JSONObject item;
        for(int i = 0; i < videos.length(); i++) {
            item = videos.getJSONObject(i);
            VideoData videoData = new VideoData();
            videoData.setDataType(DataType.CATEGORY.value());
            videoData.setId(item.optString(KEY_ID));
            videoData.setImageUrl(item.optString(KEY_IMAGE));
            videoData.setTitle(item.optString(KEY_TITLE));
            videoData.setVideoUrl(item.optString(KEY_VIDEO_URL));
            long playDuration = item.optLong(KEY_DURATION);
            videoData.setDuration(Utils.formatTimeLength(playDuration));
            list.add(videoData);
        }
        return list;
    }
}
