package com.example.gjj.retrofit19;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * 作者：gjj on 2015/12/1 18:57
 * 邮箱：Gujj512@163.com
 */
public class MyApplication extends Application{
    //上下文环境
    private static Context context;
    //获取主线程的id
    private static int mainThreadId;
    //轮训器
    //while(true)不停的从消息队列中去获取消息，
    //handler.sendMessage(msg)发送消息到消息队列中
    //生成者消费者模式，
    private static Looper mainThreadLooper;
    //获取当前线程对象
    private static Thread mainThread;
    //handler
    private static Handler handler=new Handler();
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        //获取当前线程的id
        this.mainThreadId = android.os.Process.myTid();
//        this.handler = new Handler();
        //主线程轮训器对象
        this.mainThreadLooper = getMainLooper();
        this.mainThread = Thread.currentThread();
    }
    public static Context getContext() {
        return context;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }
    public static Handler getHandler(){
        return handler;
    }
}
