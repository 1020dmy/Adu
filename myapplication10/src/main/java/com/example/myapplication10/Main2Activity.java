package com.example.myapplication10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication10.bean.BaseJavaBase;
import com.example.myapplication10.bean.JavaBean;
import com.example.myapplication10.fragment.BlankFragment;
import com.example.myapplication10.fragment.BlankFragment2;
import com.example.myapplication10.fragment.BlankFragment3;
import com.example.myapplication10.net.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private Toolbar tb;
    private ImageView image;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private JavaBean.BodyBean.ResultBean javabean;
    private ArrayList<BaseJavaBase.BodyBean.ResultBean> resultBeans;
    private int id;
    private ViewPager vp;
    private TabLayout tbt;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }


    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        resultBeans = new ArrayList<>();
        Intent intent = getIntent();
        javabean = (JavaBean.BodyBean.ResultBean) intent.getSerializableExtra("1");
        id = javabean.getID();
        Glide.with(this).load(javabean.getTeacherPic()).apply(new RequestOptions().circleCrop()).into(image);
        tv1.setText(javabean.getTeacherName());
        tv3.setText(javabean.getTitle());

        tbt = (TabLayout) findViewById(R.id.tbt);
        rl = (RelativeLayout) findViewById(R.id.rl);
    }

    private void initData() {
        final Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.ER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<BaseJavaBase> getjavabean = apiService.getBase(id);
        getjavabean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseJavaBase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseJavaBase baseJavaBase) {
                        resultBeans.addAll(baseJavaBase.getBody().getResult());
                        final BlankFragment blankFragment1 = new BlankFragment();
                        final BlankFragment2 blankFragment2 = new BlankFragment2();
                        final BlankFragment3 blankFragment3 = new BlankFragment3();
                        for (int i = 0; i < resultBeans.size(); i++) {
                            tbt.addTab(tbt.newTab().setText((resultBeans.get(i).getDescription())));
                        }
                        final FragmentManager supportFragmentManager = getSupportFragmentManager();
                        supportFragmentManager.beginTransaction().add(R.id.rl,blankFragment1).add(R.id.rl,blankFragment2).add(R.id.rl,blankFragment3).show(blankFragment1)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .commit();
                        tbt.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                            @Override
                            public void onTabSelected(TabLayout.Tab tab) {
                                if (tab.getPosition()==0){
                                    supportFragmentManager.beginTransaction().show(blankFragment1).hide(blankFragment2).hide(blankFragment3).commit();
                                }
                                if (tab.getPosition()==1){

                                    supportFragmentManager.beginTransaction().show(blankFragment2).hide(blankFragment1).hide(blankFragment3).commit();
                                }
                                if (tab.getPosition()==2){
                                    supportFragmentManager.beginTransaction().show(blankFragment3).hide(blankFragment1).hide(blankFragment2).commit();

                                }
                            }

                            @Override
                            public void onTabUnselected(TabLayout.Tab tab) {

                            }

                            @Override
                            public void onTabReselected(TabLayout.Tab tab) {

                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
