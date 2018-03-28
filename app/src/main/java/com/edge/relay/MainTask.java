package com.edge.relay;

/**
 * Created by kim on 2018. 3. 27..
 */

public interface MainTask {
    interface PresenterBridge extends BasePresenter {
        void goLogin(String email, String pwd);
    }

    interface View extends BaseView<PresenterBridge> {
        void sendResult(int code, String message);
    }
}
