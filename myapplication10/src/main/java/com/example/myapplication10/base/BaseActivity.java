package com.example.myapplication10.base;

import android.os.Bundle;

import com.example.myapplication10.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements BaseView{
    public P mpersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initPersenter();
        if (mpersenter != null){
            mpersenter.bindview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPersenter();

    protected abstract int getLayout();

}
