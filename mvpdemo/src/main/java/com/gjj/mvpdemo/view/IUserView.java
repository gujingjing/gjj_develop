package com.gjj.mvpdemo.view;

/**
 * 作者：gjj on 2015/12/2 11:43
 * 邮箱：Gujj512@163.com
 */
public interface IUserView {
    int getID();

    String getFristName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
