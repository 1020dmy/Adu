package com.example.myapplication5.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable = null;

    public void addDisposable(Disposable disposable){
        if (mdisposable==null){
            synchronized (BaseModel.class){
                if (mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
    }
    //销毁
    public void disposable(){
        mdisposable.dispose();
    }
    //删除
    public void removeDisposable(Disposable disposable){
        mdisposable.remove(disposable);
    }
}
