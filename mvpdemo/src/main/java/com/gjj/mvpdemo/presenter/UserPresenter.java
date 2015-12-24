package com.gjj.mvpdemo.presenter;

import com.gjj.mvpdemo.bean.UserBean;
import com.gjj.mvpdemo.model.IUserModel;
import com.gjj.mvpdemo.model.UserModel;
import com.gjj.mvpdemo.view.IUserView;

/**
 * 作者：gjj on 2015/12/2 11:45
 * 邮箱：Gujj512@163.com
 */
public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;
    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }
    public void saveUser( int id, String firstName, String lastName) {
        mUserModel.setId(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }
    public void loadUser( int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setFirstName(user.getmFirstName()); // 通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getmLastName());
    }
}
