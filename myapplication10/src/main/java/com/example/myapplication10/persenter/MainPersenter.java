package com.example.myapplication10.persenter;

import com.example.myapplication10.base.BasePersenter;
import com.example.myapplication10.bean.JavaBean;
import com.example.myapplication10.model.MainModel;
import com.example.myapplication10.net.MainCallBack;
import com.example.myapplication10.view.MainView;

public class MainPersenter extends BasePersenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void setData() {

        mainModel.setData(this);


    }

    @Override
    public void OnSuccess(JavaBean javaBean) {
        mview.setData(javaBean);
    }

    @Override
    public void OnFeil(String string) {

    }
}
