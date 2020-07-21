package com.example.myapplication5.persent;

import com.example.myapplication5.base.BasePersent;

import com.example.myapplication5.bean.FuliBean;
import com.example.myapplication5.model.MainMdel;
import com.example.myapplication5.net.onSuccess;
import com.example.myapplication5.uitl.ToastUtil;
import com.example.myapplication5.view.MainView;

public class MainPersent extends BasePersent<MainView> implements onSuccess {

    private MainMdel mainMdel;

    @Override
    public void initModel() {
        mainMdel = new MainMdel();
        addModel(mainMdel);
    }

    public void setData() {
        mainMdel.setData(this);
    }

    @Override
    public void OnSuccess(FuliBean fuliBean) {
        mview.setData(fuliBean);
    }

    @Override
    public void Feil(String s) {
        ToastUtil.showLong(s);
    }
}
