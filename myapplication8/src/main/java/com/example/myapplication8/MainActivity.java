package com.example.myapplication8;

import androidx.appcompat.widget.Toolbar;


import android.widget.Toast;


import com.example.myapplication8.base.BaseActitity;
import com.example.myapplication8.bean.FuliBean;
import com.example.myapplication8.persent.MainPersent;
import com.example.myapplication8.view.MainView;

public class MainActivity extends BaseActitity<MainPersent> implements MainView {
    private Toolbar tb;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mpersent.setData();
    }

    @Override
    protected void initView() {
        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);

    }

    @Override
    protected void initpersent() {
        mpersent=new MainPersent();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(FuliBean java) {

    }
}
