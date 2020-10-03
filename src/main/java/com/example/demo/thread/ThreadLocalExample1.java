package com.example.demo.thread;

public class ThreadLocalExample1 {
    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(2);
            System.out.println(threadLocal1.get() +" thread1 " +  threadLocal2.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(3);
            threadLocal2.set(4);
            System.out.println(threadLocal1.get() +" thread2 " +  threadLocal2.get());
        });
        thread1.start();
        thread2.start();
    }
}