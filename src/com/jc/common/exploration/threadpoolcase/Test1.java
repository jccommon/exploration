package com.jc.common.exploration.threadpoolcase;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java线程池的分析和使用
 */
public class Test1 {
    public static int i=0;

    public static Set<Integer> set = new HashSet<Integer>();
    public static  void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue);


        MyThreadFactory threadFactory = new MyThreadFactory();
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,threadFactory);

        MyRejectedExecutionHandler rejectedExecutionHandler = new MyRejectedExecutionHandler();
        ThreadPoolExecutor executor3 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,rejectedExecutionHandler);


        ThreadPoolExecutor executor4 = new ThreadPoolExecutor(5,10,5*60, TimeUnit.SECONDS,queue,threadFactory,rejectedExecutionHandler);


        for(int i=0;i<1000;i++){
            MyTask task = new MyTask();
            executor1.execute(task);

        }


        Thread.sleep(5000);
        System.out.println("size==="+set.size());

    }


}


