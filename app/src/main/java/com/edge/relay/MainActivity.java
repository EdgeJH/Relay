package com.edge.relay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainTask.View, View.OnClickListener {

    EditText id,pwd;
    Button login;
    MainTask.PresenterBridge presenterBridge;
    MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        id = findViewById(R.id.id);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void setPresenterBridge(MainTask.PresenterBridge presenterBridge) {
        this.presenterBridge =presenterBridge;
    }

    @Override
    public void sendResult(int code, String message) {
        switch (code){
            case 200:
                //로그인완료 인텐트
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
                break;
            case 400:
                //로그인실패 다시 시도 토스트 메세지
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String email = id.getText().toString();
                String pwdStr= pwd.getText().toString();
                presenterBridge.goLogin(email,pwdStr);
                break;
        }
    }

}
