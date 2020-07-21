package com.example.myapplication.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {
    //右手V
    public V mview;
    //左手M
    public ArrayList<BaseModel> baseModels=new ArrayList<BaseModel>();
    //绑定V
    public void binfView(V view){
        this.mview=view;
    }

    //初始化P
    public BasePersent(){
        initModel();
    }

    protected abstract void initModel();

    //添加Model
    public void addModel(BaseModel baseModel){
        baseModels.add(baseModel);
    }
    //销毁关系
    public void destroy(){
     mview=null;
        for (int i = 0; i <baseModels.size(); i++) {
            BaseModel baseModel = baseModels.get(i);
            baseModel.dectory();
        }
    }

}
