package com.example.mvplibrary.net;




import android.util.Log;
import com.example.mvplibrary.mvp.utils.base.BaseResponse;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 网络请求回调
 */
public abstract class NetCallback<T> implements Callback <T> {

    //访问成功回调
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response != null && response.body() != null && response.isSuccessful()) {
            BaseResponse baseResponse = new Gson().fromJson(new Gson().toJson(response.body()), BaseResponse.class);
            if (baseResponse.getCode() == 404) {
                Log.e("Warn", baseResponse.getData().toString());
            } else if (baseResponse.getCode() == 500) {
                Log.e("Warn", baseResponse.getData().toString());
            } else {
                onSuccess(call,response);
                Log.e("Warn","其他情况");
            }
        }else {
            onFailed();
        }
    }

    //访问失败回调
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailed();
    }

    //数据返回
    public abstract void onSuccess(Call<T> call, Response<T> response);

    //失败异常
    public abstract void onFailed();

}