package com.example.myapplication6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.myapplication6.adapter.MyAdapter;
import com.example.myapplication6.bean.JavaBean;
import com.example.myapplication6.net.ApiService;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rv;
    private ArrayList<JavaBean.T1348647909107Bean> beans;
    private MyAdapter myAdapter;
    private Button but1;
    private Button but2;
    private Button but3;
    private boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<JavaBean> getjavabean = apiService.getjavabean();
        getjavabean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        beans.addAll(javaBean.getT1348647909107());
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        beans = new ArrayList<>();
        myAdapter = new MyAdapter(beans, this);
        rv.setAdapter(myAdapter);
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(this);
        but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(this);
        but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
               myAdapter.b =true;
                myAdapter.notifyDataSetChanged();
                break;
            case R.id.but2:
                ArrayList<JavaBean.T1348647909107Bean> t = new ArrayList<>();
                for (int i = 0; i < beans.size(); i++) {

                    JavaBean.T1348647909107Bean bean = beans.get(i);
                    boolean bo = bean.isBo();
                    if (bo==false){
                        t.add(beans.get(i));
                    }

                }
                beans.clear();
                beans.addAll(t);
                myAdapter.notifyDataSetChanged();
                break;
            case R.id.but3:
               myAdapter.b =false;
                for (int i = 0; i < beans.size(); i++) {
                    JavaBean.T1348647909107Bean bean = beans.get(i);
                    bean.setBo(false);
                }
                myAdapter.notifyDataSetChanged();
                break;
        }
    }
}
