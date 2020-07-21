package com.example.myapplication5.model;

import com.example.myapplication5.base.BaseModel;
import com.example.myapplication5.bean.FuliBean;
import com.example.myapplication5.net.ApiService;
import com.example.myapplication5.net.onSuccess;
import com.example.myapplication5.uitl.BaseObserver;
import com.example.myapplication5.uitl.HttpUtils;
import com.example.myapplication5.uitl.RxUtils;

import io.reactivex.Observable;

public class MainMdel extends BaseModel {

    public void setData(final onSuccess on) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.BASE_URL, ApiService.class);
        Observable<FuliBean> fuli = apiserver.getFuli();
        fuli.compose(RxUtils.<FuliBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        on.OnSuccess(fuliBean);
                    }

                    @Override
                    protected void error(String err) {
                        on.Feil(err);
                    }
                });
    }
}
