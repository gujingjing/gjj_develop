package com.gjj.mvpdemo.model;

import com.gjj.mvpdemo.bean.UserBean;

/**
 * 作者：gjj on 2015/12/2 11:48
 * 邮箱：Gujj512@163.com
 */
public class UserModel implements IUserModel{
    UserBean userBean;
    public UserModel(){
        userBean=new UserBean();
    }
    @Override
    public void setId(int id) {
    }

    @Override
    public void setFirstName(String firstName) {
        userBean.setmFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        userBean.setmLastName(lastName);
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public UserBean load(int id) {
        return userBean;
    }
}
