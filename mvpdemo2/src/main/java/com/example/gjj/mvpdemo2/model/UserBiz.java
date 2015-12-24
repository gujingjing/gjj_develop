package com.example.gjj.mvpdemo2.model;

import com.example.gjj.mvpdemo2.bean.User;
import com.example.gjj.mvpdemo2.model.IUserBiz;
import com.example.gjj.mvpdemo2.model.OnLoginListener;

/**
 * 作者：gjj on 2015/12/2 14:35
 * 邮箱：Gujj512@163.com
 */
public class UserBiz implements IUserBiz{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
