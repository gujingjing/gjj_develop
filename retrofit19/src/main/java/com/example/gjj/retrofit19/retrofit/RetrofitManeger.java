package com.example.gjj.retrofit19.retrofit;

import com.example.gjj.retrofit19.bean.LoginToken;

import retrofit.Call;
import rx.Observable;

/**
 * 作者：gjj on 2015/12/1 10:56
 * 邮箱：Gujj512@163.com
 */
public class RetrofitManeger {
    public static RetrofitManeger retrofitService = new RetrofitManeger();
    //登录获取token
    public LoginServices loginServices=RetrofitMaker.creeatApi(LoginServices.class,HttpUrl.URL_HOST,HttpUrl.BASE_AU);
    //带token的请求
    public WithTokenServices withTokenServices=RetrofitMaker.creeatApi(WithTokenServices.class,HttpUrl.URL_HOST,HttpUrl.BASE_AU);

    /**
     * 登录获取token
     */
    public Observable getToken(String userName,String pwd){
        return loginServices.getToken(userName,pwd,"password");
    }
}
