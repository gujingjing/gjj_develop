package com.example.gjj.retrofit19.retrofit;

import com.example.gjj.retrofit19.bean.LoginToken;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * 作者：gjj on 2015/12/1 10:59
 * 邮箱：Gujj512@163.com
 */
public interface LoginServices {
    //    {{url}}/oauth/token 获取token
    @POST("oauth/token")
    @FormUrlEncoded
    Observable<LoginToken> getToken(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);
}
