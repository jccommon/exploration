package com.jc.common.exploration.threadpoolcase;

public class MyTask implements  Runnable {
    @Override
    public void run() {
        synchronized (Test1.class){
            Test1.i = Test1.i+1;
            Test1.set.add(Test1.i);
            System.out.println("size-"+ Test1.set.size());
        }
        System.out.println("i-"+ Test1.i);



    }
}
