package com.example.myapplication5.uitl;

import android.widget.Toast;



public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.sBaseApp,msg,Toast.LENGTH_LONG).show();
    }
}
