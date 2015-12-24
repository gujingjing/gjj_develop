package com.example.gjj.mvpdemo2.model;

/**
 * 作者：gjj on 2015/12/2 14:34
 * 邮箱：Gujj512@163.com
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
