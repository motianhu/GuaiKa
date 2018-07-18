package com.smona.app.guaika.mvpview;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.smona.app.guaika.bean.VideoData;

import java.util.List;

public interface VideoMvpView extends MvpLceView<List<VideoData>> {

    void showLoadMoreErrorView();

    void showLoadMoreView();

    void setLoadMoreData(List<VideoData> videos);
}
