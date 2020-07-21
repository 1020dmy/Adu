package com.example.myapplication8.base;

import android.os.Bundle;

import com.example.myapplication8.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActitity<P extends BasePersent> extends AppCompatActivity implements BaseView{

    public P mpersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initpersent();
        if (mpersent != null){
            mpersent.bindview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initpersent();

    protected abstract int getLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpersent.destroy();
        mpersent = null;
    }
}
