package com.example.myapplication5.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {

    //左手
    public ArrayList<BaseModel> mbaseModels =new ArrayList<>();
    //右手
    public V mview;

    //绑定V
    public void bindView(V view){
        mview = view;
    }
    public BasePersent(){
        initModel();
    }
    //添加Model
    public void addModel(BaseModel baseModel) {
        mbaseModels.add(baseModel);
    }
    public abstract void initModel();

    //销毁
    public void destry(){
        mview = null;
        for (int i = 0; i < mbaseModels.size(); i++) {

            mbaseModels.get(i).disposable();

        }
    }
}
