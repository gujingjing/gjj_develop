package com.example.gjj.mvpdemo2.presenter;

import android.os.Handler;

import com.example.gjj.mvpdemo2.bean.User;
import com.example.gjj.mvpdemo2.model.IUserBiz;
import com.example.gjj.mvpdemo2.model.OnLoginListener;
import com.example.gjj.mvpdemo2.model.UserBiz;
import com.example.gjj.mvpdemo2.view.IUserLoginView;

/**
 * 作者：gjj on 2015/12/2 14:47
 * 邮箱：Gujj512@163.com
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler=new Handler();
    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView=userLoginView;
        this.userBiz=new UserBiz();
    }
    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }
    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
