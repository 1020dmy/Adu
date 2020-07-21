package com.example.myapplication2.persent;

import com.example.myapplication2.base.BasePersent;
import com.example.myapplication2.model.MainModel;
import com.example.myapplication2.net.OnSuccess;
import com.example.myapplication2.view.MainView;

public class MainPersent extends BasePersent<MainView> implements OnSuccess {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addodel(mainModel);
    }

    public void setText() {
        mainModel.setText(this);
    }

    @Override
    public void onSucces(String string) {
        mView.setData(string);
    }

    @Override
    public void OnFail(String string) {

    }
}
