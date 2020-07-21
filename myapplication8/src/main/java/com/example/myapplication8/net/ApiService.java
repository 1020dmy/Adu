package com.example.myapplication8.net;

import com.example.myapplication8.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @Auther: hchen
 * @Date: 2020/7/11 0011
 * @Description:
 */
public interface ApiService {
    String BASE_URL = "http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<FuliBean> getFuli();
}
