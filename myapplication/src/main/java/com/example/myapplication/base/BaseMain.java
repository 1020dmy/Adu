package com.example.myapplication.base;

import android.os.Bundle;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMain<P extends BasePersent> extends AppCompatActivity implements BaseView{
    public P mpersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //绑定V与P
        if (mpersent!=null){
            mpersent.binfView(this);
        }
        initData();
        initListenter();//监听
        initView();
        initPersent();
    }

    protected abstract void initPersent();//创建具体页面的P

    protected abstract void initData();

    protected abstract void initView();


    protected abstract void initListenter();

    protected abstract int getLayout();

//销毁

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpersent!=null){
            mpersent.destroy();
            mpersent=null;
        }
    }
}
