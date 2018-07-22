package com.smona.app.guaika.home.http.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HomeApi {
    @GET("api/homePageList?platformType=androidPhone&isNotModified=0&adapterNo=7.0.0&protocol=1.0.0")
    Observable<String> refreshVideos(@Query("channelId") int tabId, @Query("pageSize") int pageSize, @Query("requireTime") String requireTime);

    @GET("api/homePageList?platformType=androidPhone&isNotModified=0&adapterNo=7.0.0&protocol=1.0.0")
    Observable<String> loadMoreVideos(@Query("channelId") int tabId, @Query("pageSize") int pageSize, @Query("positionId") String positionId);
}
