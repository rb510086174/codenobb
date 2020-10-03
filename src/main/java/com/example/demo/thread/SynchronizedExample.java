package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {

    //它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 20; i++) {
                System.out.println(i + " ");
            }
        }
    }
    //作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
    }
}