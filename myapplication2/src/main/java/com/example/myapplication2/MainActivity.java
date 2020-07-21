package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.base.BaseActivity;
import com.example.myapplication2.persent.MainPersent;
import com.example.myapplication2.view.MainView;

public class MainActivity extends BaseActivity<MainPersent> implements MainView {

    public TextView tv;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected void initData() {
        mpersent.setText();
    }

    @Override
    //监听
    protected void initListener() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("监听成功！");
            }
        });
    }

    @Override
    //空间
    protected void initView() {
        tv = findViewById(R.id.tv);
    }

    @Override
    //绑定P
    protected void initPersent() {
        mpersent=new MainPersent();
    }

    @Override
    //加载页面
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showtoast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(String string) {
        tv.setText(string);
    }
}
