package com.example.gjj.retrofit19.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
	private static ThreadPoolProxy threadPoolProxy;
	private static Object object = new Object();
	
	public static ThreadPoolProxy getThreadPoolProxy(){
		synchronized (object) {
			if(threadPoolProxy == null){
				threadPoolProxy = new ThreadPoolProxy(2,5,5L);
			}
			return threadPoolProxy;
		}
	}
	
	public static class ThreadPoolProxy{
		//做核心的执行任务的操作
		private int corePoolSize;
		private int maximumPoolSize;
		private long keepAliveTime;
		private ThreadPoolExecutor threadPoolExecutor;
		public ThreadPoolProxy(int corePoolSize,int maximumPoolSize,long keepAliveTime) {
			this.corePoolSize = corePoolSize;
			this.maximumPoolSize = maximumPoolSize;
			this.keepAliveTime = keepAliveTime;
		}
		//要去执行的任务
		public void execute(Runnable runnable){
			if(runnable==null){
				return;
			}
			
			if(threadPoolExecutor == null || threadPoolExecutor.isShutdown()){
				threadPoolExecutor = new ThreadPoolExecutor(
						//线程池核心线程数
						corePoolSize, 
						//最大线程数
						maximumPoolSize,
						//保持线程时长
						keepAliveTime, 
						//保持线程时长的单位
						TimeUnit.MILLISECONDS, 
						//工作队列
						new LinkedBlockingQueue<Runnable>(), 
						//线程工程的返回值结果
						Executors.defaultThreadFactory(), 
						//处理
						new AbortPolicy());
			}
			threadPoolExecutor.execute(runnable);
		}
	}
}
