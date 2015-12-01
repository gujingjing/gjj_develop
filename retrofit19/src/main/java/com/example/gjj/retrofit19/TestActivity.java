package com.example.gjj.retrofit19;

import android.view.View;

import com.example.gjj.retrofit19.base.BaseSwipActivity;
import com.example.gjj.retrofit19.bean.LoginToken;
import com.example.gjj.retrofit19.retrofit.RetrofitManeger;
import com.example.gjj.retrofit19.util.LogUtils;
import com.example.gjj.retrofit19.util.UiUtils;
import com.example.gjj.retrofit19.view.LoadingPage;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 作者：gjj on 2015/12/1 20:08
 * 邮箱：Gujj512@163.com
 */
public class TestActivity extends BaseSwipActivity{
    @Override
    public View onCreateSuccessedView() {
        return UiUtils.inflate(mActivity,R.layout.activity_main);
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        Observable<LoginToken> observable = RetrofitManeger.retrofitService.getToken("13916539504", "123456");
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginToken>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.e("onCompleted===", "onCompleted");
//                        return LoadingPage.ResultState.RESULT_STATE_SUCCESS;
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError===", e.getMessage());
//                        return LoadingPage.ResultState.RESULT_STATE_SUCCESS;
                    }

                    @Override
                    public void onNext(LoginToken loginToken) {
                        LogUtils.e("onCompleted===", loginToken.access_token + "");
//                        return LoadingPage.ResultState.RESULT_STATE_SUCCESS;
                    }
                });
        return LoadingPage.ResultState.RESULT_STATE_SUCCESS;
    }

    @Override
    public void setGui() {
        setTitleShow(true);//设置是否显示标题栏
        show();
    }

    @Override
    protected int initColor() {
        return 0;
    }
}
