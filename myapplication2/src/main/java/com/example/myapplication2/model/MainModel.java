package com.example.myapplication2.model;

import com.example.myapplication2.base.BaseModel;
import com.example.myapplication2.net.OnSuccess;

public class MainModel extends BaseModel {
    public void setText(OnSuccess onSuccess) {
        String string="12346546";
        onSuccess.onSucces(string);
    }
}
