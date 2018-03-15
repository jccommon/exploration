package com.jc.common.exploration.threadpoolcase;

public class MyTask implements  Runnable {

    public void run2() {
        synchronized (Test1.class){
            Test1.i = Test1.i+1;
            Test1.set.add(Test1.i);
            System.out.println("size-"+ Test1.set.size());
        }
        System.out.println("i-"+ Test1.i);



    }

    public void run() {
        Test1.i = Test1.i+1;
        Test1.set.add(Test1.i);
        System.out.println("size-"+ Test1.set.size());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i-"+ Test1.i);



    }
}
