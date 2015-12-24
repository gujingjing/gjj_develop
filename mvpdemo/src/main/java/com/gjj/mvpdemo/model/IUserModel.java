package com.gjj.mvpdemo.model;

import com.gjj.mvpdemo.bean.UserBean;

/**
 * 作者：gjj on 2015/12/2 11:41
 * 邮箱：Gujj512@163.com
 */
public interface IUserModel {
    void setId(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getId();

    UserBean load(int id);// 通过id读取user信息,返回一个UserBean
}
