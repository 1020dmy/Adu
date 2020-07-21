package com.example.myapplication5;

import android.content.Intent;
import android.widget.Toast;

import com.example.myapplication5.adaper.MyAdapter;
import com.example.myapplication5.base.BaseActivity;
import com.example.myapplication5.bean.FuliBean;
import com.example.myapplication5.persent.MainPersent;
import com.example.myapplication5.view.MainView;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity<MainPersent> implements MainView {

    private RecyclerView rv;
    private ArrayList<FuliBean.ResultsBean> resultsBeans;
    private MyAdapter myAdapter;
    private Toolbar tb;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    @Override
    public void initData() {
        mpersent.setData();
    }

    @Override
    protected void initListener() {
        myAdapter.setOn(new MyAdapter.On() {
            @Override
            public void Click(int position) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }


    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);
        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        resultsBeans = new ArrayList<>();
        myAdapter = new MyAdapter(resultsBeans, this);
        rv.setAdapter(myAdapter);
    }

    @Override
    protected void initPersent() {
        mpersent = new MainPersent();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(FuliBean fuliBean) {
        resultsBeans.addAll(fuliBean.getResults());
        myAdapter.notifyDataSetChanged();
    }
}
