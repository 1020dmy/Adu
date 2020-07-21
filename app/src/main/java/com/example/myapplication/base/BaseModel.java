package com.example.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;

public abstract class BaseModel {
    //用于取消订阅的消息
    private CompositeDisposable disposeOn=null;
    public void addDisposeOn(Disposable disposable){
        if (disposeOn==null){
            synchronized (BaseModel.class){
                if (disposeOn==null){
                    disposeOn=new CompositeDisposable();
                }
            }
        }
        //把disposable添加到disposeOn中
        disposeOn.add(disposable);
    }
    //有M层把网络订阅的取消
    public void dispse(){
        disposeOn.dispose();
    }
    //移除disposable
    public void remove(Disposable disposable){
        if (disposeOn!=null){
        disposeOn.remove(disposable);
        }
    }
}
