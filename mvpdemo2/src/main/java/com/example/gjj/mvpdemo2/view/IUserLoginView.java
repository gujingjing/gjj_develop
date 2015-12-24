package com.example.gjj.mvpdemo2.view;

import com.example.gjj.mvpdemo2.bean.User;

/**
 * 作者：gjj on 2015/12/2 14:42
 * 邮箱：Gujj512@163.com
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);//登录成功的操作

    void showFailedError();
}
