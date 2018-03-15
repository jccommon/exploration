package com.jc.common.exploration.synchronizedcase;

/**
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，其它试图访问该对象的线程将被阻塞
 */
public class Test2 implements Runnable {


    public static  void main(String[] args){


        Test2 syncThread = new Test2();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();


//        Test2 syncThread1 = new Test2();
//        Test2 syncThread2 = new Test2();
//
//        Thread thread3 = new Thread(syncThread1, "SyncThread3");
//        Thread thread4 = new Thread(syncThread2, "SyncThread4");
//        thread3.start();
//        thread4.start();


    }


    private int count;

    public Test2() {
        count = 0;
    }


    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public int getCount() {
        return count;
    }



}
