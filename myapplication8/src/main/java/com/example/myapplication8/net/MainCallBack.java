package com.example.myapplication8.net;

import com.example.myapplication8.bean.FuliBean;

public interface MainCallBack {
    void onSuccess(FuliBean fuliBean);
    void onFeil(String string);
}
