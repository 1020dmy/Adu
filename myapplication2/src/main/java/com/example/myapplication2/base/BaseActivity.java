package com.example.myapplication2.base;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePersent> extends AppCompatActivity implements BaseView{
    public P mpersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initPersent();
        if (mpersent!=null){
            mpersent.bindview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initPersent();

    protected abstract int getLayout();


}
