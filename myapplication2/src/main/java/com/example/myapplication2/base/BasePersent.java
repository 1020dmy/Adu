package com.example.myapplication2.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {
    //右手
    public V mView;
    //左手
    public ArrayList<BaseModel> mModels=new ArrayList<>();
    //绑定V
    public void bindview(V view){
        mView = view;
    }
    //
    public BasePersent(){
        initModel();
    }

    public void addodel(BaseModel baseModel){
        mModels.add(baseModel);
    }


    protected abstract void initModel();


    public void destroy(){
        mView = null;
        for (int i = 0; i < mModels.size(); i++) {

            mModels.get(i).disposable();


        }
    }

}
