package com.example.gjj.retrofit19.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.example.gjj.retrofit19.MyApplication;

/**
 * 作者：gjj on 2015/12/1 19:00
 * 邮箱：Gujj512@163.com
 */
public class UiUtils {
    public static Handler getHandler(){
        return MyApplication.getHandler();
    }
    public static Context getContext(){
        return MyApplication.getContext();
    }
    //判断当前线程是否运行在主线程内
    public static boolean isRunInMainThread(){
        return MyApplication.getMainThreadId() == android.os.Process.myTid();
    }
    //封装UI操作维护在主线程里面
    public static void runInMainThread(Runnable runnable){
        if(isRunInMainThread()){
            runnable.run();
        }else{
            //通过handler将当前任务传递到主线程中去做处理
            getHandler().post(runnable);
        }
    }
    public static View inflate(Context context,int id){
        return View.inflate(context, id, null);
    }

}
