package com.example.myapplication10.model;

import com.example.myapplication10.base.BaseModel;
import com.example.myapplication10.bean.JavaBean;
import com.example.myapplication10.net.ApiService;
import com.example.myapplication10.net.MainCallBack;
import com.example.myapplication10.persenter.MainPersenter;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void setData(final MainCallBack callBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<JavaBean> getjavabean = apiService.getjavabean();
        getjavabean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        callBack.OnSuccess(javaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnFeil(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
