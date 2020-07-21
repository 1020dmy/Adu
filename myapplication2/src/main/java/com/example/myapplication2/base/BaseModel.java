package com.example.myapplication2.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable = null;

    public void addDisposaable(Disposable disposable){
        if (mdisposable==null){
            synchronized (BaseModel.class){
            if (mdisposable==null){
                mdisposable = new CompositeDisposable();
            }
            }
        }
        mdisposable.add(disposable);
    }

    //删除
    public  void removedisposable(Disposable disposable){
        mdisposable.remove(disposable);
    }
    //销毁
    public void disposable(){
        mdisposable.dispose();
    }
}
