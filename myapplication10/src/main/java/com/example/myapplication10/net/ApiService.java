package com.example.myapplication10.net;

import com.example.myapplication10.bean.BaseJavaBase;
import com.example.myapplication10.bean.JavaBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String BASE_URL="https://api.yunxuekeji.cn/yunxue_app_api/";

    @GET("content/getData/30/66597/1/10")

    Observable<JavaBean> getjavabean();

    String ER_BASE_URL="https://api.yunxuekeji.cn/yunxue_app_api/";

    @GET("teacher/getTeacherPower/{i}")
    Observable<BaseJavaBase> getBase(@Path("i") int i);

}
