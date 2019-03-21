package com.test.hh.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by 170387 on 2019/3/21.
 */
@Component
public class AsyncTask {
    
    @Async
    public Future<String> task1(int i) throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task1任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms"+",and "+i);
        return new AsyncResult<String>("task1执行完毕");
    }
    
    @Async
    public Future<String> task2() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task2任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return new AsyncResult<String>("task2执行完毕");
    }
    @Async
    public Future<String> task3() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(3000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return new AsyncResult<String>("task3执行完毕");
    }
}
