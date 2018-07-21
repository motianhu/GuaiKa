package com.smona.app.guaika.factory;

import com.smona.app.guaika.http.service.IFengApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitFactory {

    private static final int TIME_OUT = 12;//超时时间
    private static final String IFENG_BASE_URL = "http://vcis.ifeng.com/";
    private static volatile IFengApi sIFengService;

    public static IFengApi getVideoService() {
        if (sIFengService == null) {
            synchronized (RetrofitFactory.class) {
                if (sIFengService == null) {
                    sIFengService = createService();
                }
            }
        }
        return sIFengService;
    }

    private static IFengApi createService() {
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
        return retrofit.create(IFengApi.class);
    }
}
