package com.jc.common.exploration.forkjoincase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask 用于处理需要有返回结果的任务
 */
public class Test1 {
    public static void main(String[] args){
        ForkJoinPool forkJoinPool =new ForkJoinPool();
        CountTask task =new CountTask(1, 9);

        Future result = forkJoinPool.submit(task);


        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}


class CountTask extends RecursiveTask {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;
    public  CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start) <= THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum += i;
            }

        }else {
            int middle = (start+end) / 2;
            CountTask leftTask =new CountTask(start, middle);
            CountTask rightTask =new CountTask(middle + 1,end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待子任务执行完，并得到其结果
            int leftResult = (int)leftTask.join();
            int rightResult = (int)rightTask.join();

            //合并子任务
            sum = leftResult  + rightResult;

        }

        return sum;
    }
}