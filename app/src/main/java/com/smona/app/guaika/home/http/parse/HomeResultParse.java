package com.smona.app.guaika.home.http.parse;

import com.google.gson.JsonObject;
import com.smona.app.guaika.main.bean.IFengInfo;
import com.smona.app.guaika.home.bean.VideoData;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.util.DataKeeper;
import com.smona.app.guaika.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HomeResultParse implements ResultParse {
    private static final String KEY_TAB_LIST = "channelInfo";
    private static final String KEY_TAB_ID = "channelId";
    private static final String KEY_TAB_NAME = "channelName";

    private static final String MEMBER_TYPE = "video";
    private static final String KEY_DATA_LIST = "bodyList";
    private static final String KEY_DATA_ITEMID = "itemId";
    private static final String KEY_DATA_ID = "infoId";
    private static final String KEY_DATA_TITLE = "title";
    private static final String KEY_DATA_TYPE = "memberType";
    private static final String KEY_DATA_VIDEO_ITEM = "memberItem";
    private static final String KEY_DATA_VIDEO_DURATION = "duration";
    private static final String KEY_DATA_IMAGE_LIST = "imageList";
    private static final String KEY_DATA_VIDEO_IMAGE = "image";
    private static final String KEY_DATA_VIDEO_DATA_LIST = "videoFiles";
    private static final String KEY_DATA_VIDEO_URL = "mediaUrl";

    @Override
    public List<VideoData> parse(JSONObject json) throws JSONException {

        List<VideoData> list = new ArrayList<>();

        JSONArray array = json.getJSONArray(KEY_DATA_LIST);
        JSONObject item;
        for (int i = 0; i < array.length(); i++) {
            item = array.getJSONObject(i);
            String type = item.optString(KEY_DATA_TYPE);
            if (!MEMBER_TYPE.equals(type)) {
                continue;
            }
            VideoData videoData = new VideoData();
            videoData.setDataType(DataType.HOME.value());
            videoData.setId(item.optString(KEY_DATA_ID));
            videoData.setTitle(item.optString(KEY_DATA_TITLE));

            JSONArray images = item.getJSONArray(KEY_DATA_IMAGE_LIST);
            JSONObject image = images.getJSONObject(0);
            videoData.setImageUrl(image.optString(KEY_DATA_VIDEO_IMAGE));

            JSONObject video = item.getJSONObject(KEY_DATA_VIDEO_ITEM);

            long duration = video.optLong(KEY_DATA_VIDEO_DURATION);
            videoData.setDuration(Utils.formatTimeLength(duration));
            video = video.getJSONArray(KEY_DATA_VIDEO_DATA_LIST).getJSONObject(1);
            videoData.setVideoUrl(video.optString(KEY_DATA_VIDEO_URL));

            videoData.setAuthor("飞龙在天");
            videoData.setLikeCount(2356);

            list.add(videoData);

            if (i == array.length() - 1) {
                String itemId = item.optString(KEY_DATA_ITEMID);
                int tabId = DataKeeper.getCurrentTabId();
                IFengInfo.save(new IFengInfo(tabId, itemId));
            }
        }
        return list;
    }
}
