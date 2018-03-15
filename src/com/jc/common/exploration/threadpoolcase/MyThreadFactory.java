package com.jc.common.exploration.threadpoolcase;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread();

        return t;
    }
}
