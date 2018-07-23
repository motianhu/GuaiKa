package com.smona.app.guaika.more.http.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MoreApi {
    @GET("recommend/getChanListNews?channel=T1457068979049&fn=3&passport=h3o88AuDhdH7tlyrE3hlILX2WMCoMqapk08GhEzPqX4%3D&devId=DWT861zlolJo7mHnyynnGA%3D%3D&version=15.0&net=wifi&ts=1474185450&sign=JmMhXTnPo%2BqgTgwyxKstDgS9lmS5Pv%2BUCP5tZ%2FrWevV48ErR02zJ6%2FKXOnxX046I&encryption=1")
    Observable<String> getVideos(@Query("size") int size, @Query("offset") int offset);
}
