package com.smona.app.guaika.more.factory;

import com.smona.app.guaika.more.http.service.MoreApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MoreRetrofitFactory {

    private static final int TIME_OUT = 12;//超时时间
    private static final String NETEASY_BASE_URL = "http://c.m.163.com/";
    private static volatile MoreApi sNetEasyService;

    public static MoreApi getCatgoryService() {
        if(sNetEasyService == null) {
            synchronized (MoreRetrofitFactory.class) {
                if(sNetEasyService == null) {
                    sNetEasyService = createCategoryService();
                }
            }
        }
        return sNetEasyService;
    }

    private static MoreApi createCategoryService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NETEASY_BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(MoreApi.class);
    }
}
