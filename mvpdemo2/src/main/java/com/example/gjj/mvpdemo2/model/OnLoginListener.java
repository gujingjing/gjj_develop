package com.example.gjj.mvpdemo2.model;

import com.example.gjj.mvpdemo2.bean.User;

/**
 * 作者：gjj on 2015/12/2 14:37
 * 邮箱：Gujj512@163.com
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
