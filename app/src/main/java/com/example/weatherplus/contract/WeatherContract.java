package com.example.weatherplus.contract;


import android.content.Context;

import com.example.mvplibrary.mvp.utils.base.BasePresenter;
import com.example.mvplibrary.mvp.utils.base.BaseView;
import com.example.mvplibrary.net.NetCallback;
import com.example.mvplibrary.net.ServiceGenerator;
import com.example.weatherplus.api.ApiService;
import com.example.weatherplus.bean.TodayResponse;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 天气订阅器
 */
public class WeatherContract {
    public static class WeatherPresenter extends BasePresenter<IWeatherView>{
        /**
         * 当日天气
         * @param context
         * @param location  区/县
         */
        public void todayWeather(final Context context, String location){
            //得到构建之后的网络请求服务，这里的地址已经拼接完成，只差一个Location了
            ApiService service = ServiceGenerator.createService(ApiService.class);
            //设置请求回调 NetCallBack是重写请求回调
            service.getTodayWeather(location).enqueue(new NetCallback<TodayResponse>() {
                //成功回调
                @Override
                public void onSuccess(Call<TodayResponse> call, Response<TodayResponse> response) {
                    if(getView() != null){
                        getView().getTodayWeatherResult(response);
                    }
                }

                //失败回调
                @Override
                public void onFailed() {
                    if(getView() != null){
                        getView().getDataFailed();
                    }
                }
            });
        }
    }

    public interface IWeatherView extends BaseView{

        //将数据放入实体
        void getTodayWeatherResult(Response<TodayResponse> response);

        //错误返回
        void getDataFailed();
    }
}
