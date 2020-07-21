package com.example.myapplication10.base;

import java.util.ArrayList;

public abstract class BasePersenter<V extends BaseView> {

    public V mview;

    public ArrayList<BaseModel> mModels=new ArrayList<>();

    public BasePersenter(){
        initModel();
    }

    protected abstract void initModel();

    public void bindview(V view){
        mview=view;
    }
    public void addModel(BaseModel baseModel){
        mModels.add(baseModel);
    }

    public void destroy(){
        mview = null;
        for (int i = 0; i < mModels.size(); i++) {

            BaseModel baseModel = mModels.get(i);
            baseModel.disable();

        }
    }

}
