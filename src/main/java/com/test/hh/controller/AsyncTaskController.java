package com.test.hh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by 170387 on 2019/3/21.
 */
//@RequestMapping("")
@RestController
public class AsyncTaskController {
    
    @Autowired
    private AsyncTask asyncTask;
    
    @RequestMapping("/doTask")
    public String doTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
    
        List< Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i <3;i++) {
            Future<String> task = asyncTask.task1(i);
            futures.add(task);
        }
        
//        Future<String> task1 = asyncTask.task1();
//        Future<String> task2 = asyncTask.task2();
//        Future<String> task3 = asyncTask.task3();
        String result = null;
        for (;;) {
            boolean flag = true;
            for (Future<String> task : futures) {
                flag = flag && task.isDone();
            }
            
            if(flag) {
                // 多个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
    
        for (Future<String> task : futures) {
            try {
                System.out.println("task is ok "+ task.get() );
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ceshi hahaha is test2 okok");
        return result;
        
        
    }
}
