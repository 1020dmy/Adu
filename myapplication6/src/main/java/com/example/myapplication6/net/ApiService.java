package com.example.myapplication6.net;

import com.example.myapplication6.bean.JavaBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="http://c.m.163.com/nc/article/";

    @GET("headline/T1348647909107/0-20.html")

    Observable<JavaBean> getjavabean();

}
