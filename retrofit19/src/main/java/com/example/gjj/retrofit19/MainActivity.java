package com.example.gjj.retrofit19;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.gjj.retrofit19.bean.LoginToken;
import com.example.gjj.retrofit19.retrofit.RetrofitManeger;
import com.example.gjj.retrofit19.util.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.content_title_layout)
    LinearLayout contentTitleLayout;
    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTitle();
        initGui();
        Observable<LoginToken> observable = RetrofitManeger.retrofitService.getToken("13916539504", "123456");
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginToken>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.e("onCompleted===", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError===", e.getMessage());
                    }

                    @Override
                    public void onNext(LoginToken loginToken) {
                        LogUtils.e("onCompleted===", loginToken.access_token + "");
                    }
                });

    }

    public void initTitle() {
//        mTitleBarView = new TitleBarView(MainActivity.this);
//        contentTitleLayout.addView(mTitleBarView.setup());
//        mTitleBarView.setBackground(R.color.title_background);//设置背景资源
//        mTitleBarView.setTitle(R.string.title);
//        mTitleBarView.setLeftButton(R.drawable.title_left, 0, R.string.title);
//        mTitleBarView.setRightButton(R.drawable.title_left,0,R.string.title);
    }

    public void initGui() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
