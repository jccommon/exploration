package com.jc.common.exploration.volatilecase;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile关键字用法
 */
public class Test1 {

    public static volatile Test1 singleton;
    private Test1() {};


    public static Test1 getInstance() {
        if(singleton == null){
            synchronized (singleton){
                if(singleton == null){
                    singleton = new Test1();
                }
            }
        }

        return singleton;

    }


}


