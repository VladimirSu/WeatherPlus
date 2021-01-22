package com.example.weatherplus;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.weatherplus.utils.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.security.Permissions;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView location_details;
    RxPermissions rxPermissions;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        /**
         * 获取定位的方法
         */
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            double latitude = aMapLocation.getLatitude();//获取纬度
            double longitude = aMapLocation.getLongitude();//获取经度
            float radius = aMapLocation.getAccuracy();//获取精度信息
            String address = aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
            String country = aMapLocation.getCountry();//国家信息
            String province = aMapLocation.getProvince();//省信息
            String city = aMapLocation.getCity();//城市信息
            String district = aMapLocation.getDistrict();//城区信息
            String street = aMapLocation.getStreet();//街道信息
            String streetNum = aMapLocation.getStreetNum();//街道门牌号信息
            String cityCode = aMapLocation.getCityCode();//城市编码
            String AdCode = aMapLocation.getAdCode();//地区编码
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location_details = (TextView) findViewById(R.id.tv_address_detail);
        rxPermissions = new RxPermissions(this);
        permissionVersion();//权限判断
    }

    //权限判断
    private void permissionVersion() {
        if (Build.VERSION.SDK_INT >= 23) {//6.0或6.0以上
            //动态权限申请
            permissionsRequest();
        } else {//6.0以下
            //发现只要权限在AndroidManifest.xml中注册过，进行提示
            ToastUtils.showShortToast(this, "你的版本在Android6.0以下，不需要动态申请权限。");
        }
    }


    //权限申请判断
    @SuppressLint("CheckResult")
    private void permissionsRequest(){
        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {//申请成功
                        //得到权限之后开始定位
                        startLocation();
                    } else {//申请失败
                        ToastUtils.showShortToast(this, "权限未开启");
                    }
                });
    }

    private void startLocation(){
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationClient = new AMapLocationClient(this);

        //注册监听函数
        mLocationClient.unRegisterLocationListener(mLocationListener);

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    private void showLocation(String info){
        location_details.setText(info);
    }

    /**
     * 获取天气信息
     * 使用POST方法异步请求
     */

    private void getTodayWeather(String aimLocation){
        new Thread(new Runnable() {//开启子线程
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("location",aimLocation)  //添加传递键值参数
                            .build();
                    Request request = new Request.Builder()
                            .url()  //请求数据地址
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responceData = response.body().string();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
