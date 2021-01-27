package com.example.mvplibrary.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 服务构建器API服务设置在里面
 * 封装OKHttp，重写CallBack
 */
public class ServiceGenerator {
    //https://free-api.heweather.net/s6/weather/now?key=3086e91d66c04ce588a7f538f917c7f4&location=深圳
    //将上方的API接口地址进行拆分得到不变的一部分,实际开发中可以将这一部分作为服务器的ip访问地址
    public static String BASE_URL =  "https://free-api.heweather.net"; //地址

    //创建服务  参数就是API服务
    public static <T> T createService(Class<T> serviceClass) {

        //创建OkHttpClient构建器对象
        OkHttpClient.Builder okHttpClientBuider = new OkHttpClient.Builder();

        //设置请求超时的时间，这里是10秒
        okHttpClientBuider.connectTimeout(10000, TimeUnit.MILLISECONDS);

        //在Retrofit中设置httpclient
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuider.build())
                .build();
        return retrofit.create(serviceClass);
    }
}
