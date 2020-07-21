package com.example.myapplication8.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable=null;

    public void addDisposable(Disposable disposable){
        if (mdisposable == null){
            synchronized (BaseModel.class){
                mdisposable = new CompositeDisposable();
            }
        //mdisposable.add(disposable);
        }
    }

    //删除
    public void removeDisposable(Disposable disposable){
        mdisposable.remove(disposable);
    }
    //
    public void disposable(){
        mdisposable.dispose();
    }

}
