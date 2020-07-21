package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.base.BaseMain;
import com.example.myapplication.persent.MainPersent;
import com.example.myapplication.view.MainView;

public class MainActivity extends BaseMain<MainPersent> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
//获取具体的P页面
    protected void initPersent() {
        mpersent=new MainPersent();

    }

    @Override
    //网络加载
    protected void initData() {

    }

    @Override
    //设置方法
    protected void initView() {

    }

    @Override
//设置监听
    protected void initListenter() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showtoast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
