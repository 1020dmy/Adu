package com.example.myapplication8.persent;

import com.example.myapplication8.base.BasePersent;
import com.example.myapplication8.bean.FuliBean;
import com.example.myapplication8.model.MainModel;
import com.example.myapplication8.net.MainCallBack;
import com.example.myapplication8.view.MainView;

public class MainPersent extends BasePersent<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(FuliBean fuliBean) {
        
    }

    @Override
    public void onFeil(String string) {

    }

    public void setData() {
        mainModel.setData(this);
    }
}
