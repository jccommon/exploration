package com.jc.common.exploration.synchronizedcase;

/**
 *  synchronized修饰一个类
 *
 *
 */
public class Test6 {
    public static  void main(String[] args) {
        SynchThread syncThread1 = new SynchThread();
        SynchThread syncThread2 = new SynchThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }

}
class SynchThread implements Runnable {
    private static int count;

    public SynchThread() {
        count = 0;
    }

    public static void method() {
        synchronized(SynchThread.class) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void run() {
        method();
    }
}
