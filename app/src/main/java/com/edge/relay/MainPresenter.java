package com.edge.relay;

/**
 * Created by kim on 2018. 3. 27..
 */

public class MainPresenter implements MainTask.PresenterBridge,MainCallback{
    MainTask.View view;
    MainModel mainModel;

    public MainPresenter(MainTask.View view) {
        this.view = view;
        view.setPresenterBridge(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void goLogin(String email, String pwd) {
        mainModel = new MainModel(email,pwd,this);
        mainModel.loign();
    }

    @Override
    public void sendResult(int code, String message) {
        view.sendResult(code,message);
    }
}
