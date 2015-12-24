package com.example.gjj.mvpdemo2.bean;

/**
 * 作者：gjj on 2015/12/2 14:19
 * 邮箱：Gujj512@163.com
 */
public class User {
    private String username ;
    private String password ;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
