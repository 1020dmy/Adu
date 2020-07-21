package com.example.myapplication5.base;

import android.os.Bundle;

import com.example.myapplication5.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePersent> extends AppCompatActivity implements BaseView {
    public P mpersent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initPersent();//绑定P
        //绑定V
        if (mpersent!=null){
            mpersent.bindView(this);
        }
        initView();//组件
        initData();//jiexi
        initListener();//监听
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPersent();

    protected abstract int getLayout();

}
