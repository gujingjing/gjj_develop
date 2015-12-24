package com.example.gjj.mvpdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.gjj.mvpdemo2.bean.User;
import com.example.gjj.mvpdemo2.presenter.UserLoginPresenter;
import com.example.gjj.mvpdemo2.view.IUserLoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    @Bind(R.id.userName)
    EditText userName;
    @Bind(R.id.passWord)
    EditText passWord;
    @Bind(R.id.login)
    Button login;
    @Bind(R.id.clear)
    Button clear;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    private UserLoginPresenter mUserLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mUserLoginPresenter=new UserLoginPresenter(this);
    }

    @OnClick({R.id.login,R.id.clear})void onclick(View view){
        switch (view.getId()){
            case R.id.login:
                mUserLoginPresenter.login();
                break;
            case R.id.clear:
                mUserLoginPresenter.clear();
                break;
        }
    }
    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return passWord.getText().toString();
    }

    @Override
    public void clearUserName() {
        userName.setText("");
    }

    @Override
    public void clearPassword() {
        passWord.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"加载失败",Toast.LENGTH_SHORT).show();
    }
}
