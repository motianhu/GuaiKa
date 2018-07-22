package com.smona.app.guaika.home.factory;

import com.smona.app.guaika.home.http.service.HomeApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HomeRetrofitFactory {

    private static final int TIME_OUT = 12;//超时时间
    private static final String IFENG_BASE_URL = "http://vcis.ifeng.com/";
    private static volatile HomeApi sIFengService;

    public static HomeApi getVideoService() {
        if (sIFengService == null) {
            synchronized (HomeRetrofitFactory.class) {
                if (sIFengService == null) {
                    sIFengService = createService();
                }
            }
        }
        return sIFengService;
    }

    private static HomeApi createService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IFENG_BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(HomeApi.class);
    }
}
