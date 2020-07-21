package com.example.myapplication10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.myapplication10.adapter.MyAdapter;
import com.example.myapplication10.base.BaseActivity;
import com.example.myapplication10.bean.JavaBean;
import com.example.myapplication10.persenter.MainPersenter;
import com.example.myapplication10.view.MainView;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends BaseActivity<MainPersenter> implements MainView {

    private RecyclerView rv;
    private ArrayList<JavaBean.BodyBean.ResultBean> resultBeans;
    private MyAdapter myAdapter;
    private Toolbar tb;

    @Override
    protected void initListener() {
        myAdapter.setOn(new MyAdapter.On() {
            @Override
            public void Click(int position) {
                JavaBean.BodyBean.ResultBean resultBean = resultBeans.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("1",resultBean);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void initData() {
        mpersenter.setData();
    }

    @Override
    protected void initView() {
        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        resultBeans = new ArrayList<>();
        myAdapter = new MyAdapter(MainActivity.this, resultBeans);
        rv.setAdapter(myAdapter);
    }

    @Override
    protected void initPersenter() {
        mpersenter = new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showtoast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(JavaBean javaBean) {
        resultBeans.addAll(javaBean.getBody().getResult());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
