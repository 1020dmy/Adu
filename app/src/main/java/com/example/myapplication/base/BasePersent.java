package com.example.myapplication.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {
    //右手
    public V mView;
    //左手
    public ArrayList<BaseModel> mModel= new ArrayList<BaseModel>();

    //绑定View
    public void bindView(V view){
        this.mView=view;
    }

    public BasePersent(){
        //初始化model
        initModel();

    }
    //自动生成
    public abstract void initModel();

    //收集p中的所有model
    public void addModel(BaseModel baseModel){
        mModel.add(baseModel);
    }

    //销毁关系（解除绑定关系）
    public void destroy(){
        //直接销毁view
        mView=null;
        //for循环来销毁m
        for (int i = 0; i < mModel.size(); i++) {
            BaseModel baseModel = mModel.get(i);
            baseModel.dispse();
        }
    }


}
