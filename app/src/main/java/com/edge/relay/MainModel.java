package com.edge.relay;

/**
 * Created by kim on 2018. 3. 27..
 */

public class MainModel {
    String email,pwd;
    MainCallback mainCallback;

    public MainModel(String email, String pwd, MainCallback mainCallback) {
        this.email = email;
        this.pwd = pwd;
        this.mainCallback = mainCallback;
    }


    public void loign(){
        //로그인 처리 통신
        mainCallback.sendResult(200,"로그인이 완료되었습니다");
    }
}
