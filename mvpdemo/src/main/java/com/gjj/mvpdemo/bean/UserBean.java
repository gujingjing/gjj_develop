package com.gjj.mvpdemo.bean;

/**
 * 作者：gjj on 2015/12/2 11:40
 * 邮箱：Gujj512@163.com
 */
public class UserBean {
    private String mFirstName;
    private String mLastName;

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                '}';
    }
}
