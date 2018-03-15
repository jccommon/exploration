package com.jc.common.exploration.threadpoolcase;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java线程池的分析和使用
 *
 * corePoolSize 线程池的基本线程数
 * maximumPoolSize 线程池最大线程数
 * keepAliveTime 工作线程空闲后保持活动的时间
 * milliseconds 单位
 * runnableTaskQueue 任务队列  LinkedBlockingQueue
 * threadFactory 自定义创建线程工厂
 * rejectedExecutionHandler 饱和策略
 *              AbortPolicy－默认抛异常 queue超过100 java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
 *              DiscardPolicy-不处理丢弃掉
 *              DiscardOldestPolicy－丢弃队列里最近的一个任务，并执行但前任务
 *              CallerRunsPolicy 只用调用者所在线程来运行任务
 *              RejectedExecutionHandler 可以实现接口自定义策略
 */
public class Test1 {
    public static int i=0;

    public static Set<Integer> set = new HashSet<Integer>();
    public static  void main(String[] args) throws InterruptedException {
          LinkedBlockingQueue queue = new LinkedBlockingQueue(100);
          ThreadPoolExecutor executor1 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue);
//
//
          MyThreadFactory threadFactory = new MyThreadFactory();
//        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,threadFactory);
//
          MyRejectedExecutionHandler rejectedExecutionHandler = new MyRejectedExecutionHandler();
//        ThreadPoolExecutor executor3 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,rejectedExecutionHandler);
//
//
//        ThreadPoolExecutor executor4 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,threadFactory,rejectedExecutionHandler);

        // 设置饱和策略
        executor1.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy());


        for(int i=0;i<1000;i++){
            MyTask task = new MyTask();
            executor1.execute(task);
            System.out.println("TaskCount="+executor1.getTaskCount()+"  completedTaskCount="+executor1.getCompletedTaskCount()+ " largestPoolSize="+executor1.getLargestPoolSize()+" getPoolSize="+ executor1.getPoolSize()+" getActiveCount="+executor1.getActiveCount() +" queue＝"+queue.size());



        }




        Thread.sleep(5000);
        System.out.println("size==="+set.size());

    }


}


