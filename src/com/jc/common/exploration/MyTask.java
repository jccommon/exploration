package com.jc.common.exploration;

public class MyTask implements  Runnable {
    @Override
    public void run() {
        synchronized (Test.class){
            Test.i = Test.i+1;
            Test.set.add(Test.i);
            System.out.println("size-"+Test.set.size());
        }
        System.out.println("i-"+Test.i);


    }
}
