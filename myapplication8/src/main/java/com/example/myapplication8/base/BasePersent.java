package com.example.myapplication8.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {

    public V mview;

    public ArrayList<BaseModel> mModels=new ArrayList<>();

    //绑定V
    public void bindview(V view){
        mview = view;
    }

    //创建P
    public BasePersent(){
        initModel();
    }
    public void addModel(BaseModel baseModel) {
        mModels.add(baseModel);
    }

    protected abstract void initModel();

    public void destroy(){
        mview = null;
        for (int i = 0; i < mModels.size(); i++) {

            BaseModel baseModel = mModels.get(i);
            baseModel.disposable();

        }
    }


}
