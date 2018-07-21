package com.smona.app.guaika.home.mvpview;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.smona.app.guaika.home.bean.VideoData;

import java.util.List;

public interface VideoMvpView extends MvpLceView<List<VideoData>> {

    void showLoadMoreErrorView();

    void showLoadMoreView();

    void setLoadMoreData(List<VideoData> videos);
}
