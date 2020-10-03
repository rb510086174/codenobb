package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created By RenBin6 on 2020/9/3 .
 */
public class ExcutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            executorService.execute(new FutureTask<Integer>(new MyCallable()));
        }
        executorService.shutdown();
    }
}
