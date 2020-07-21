package com.example.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable = null;

    public void addDisposable(Disposable disposable){
        if (mdisposable==null){
            synchronized (BaseModel.class){
                mdisposable = new CompositeDisposable();
            }
        }
        mdisposable.add(disposable);
    }

    //销毁
    public void romovedisposable(Disposable disposable){
        mdisposable.remove(disposable);
    }
    //移除
    public void dectory(){
        mdisposable.dispose();
    }
}
