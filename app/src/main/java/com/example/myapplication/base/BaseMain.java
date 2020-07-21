package com.example.myapplication.base;

import android.os.Bundle;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMain<P extends BasePersent> extends AppCompatActivity implements BaseView{

    public P mPersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //解绑V与P
        if (mPersent!=null){
            mPersent.bindView(this);
        }
        initPresent();
        initData();
        initView();
        initListener();
    }

    public abstract void initListener();//初始化监听

    public abstract void initView();//初始化组件

    public abstract void initData();//初始化数据

    public abstract void initPresent();//获得P 创建具体P的页面

    public abstract int getLayout();//绑定布局

    @Override
    //销毁
    protected void onDestroy() {
        super.onDestroy();
        if (mPersent!=null){
            mPersent.destroy();
            mPersent=null;
        }
    }
}
