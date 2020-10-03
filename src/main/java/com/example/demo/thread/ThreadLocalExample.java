package com.example.demo.thread;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("thread2 " + threadLocal.get());
            threadLocal.remove();
        });

        thread1.start();
        System.out.println("main1 " + threadLocal.get());

        thread2.start();
        System.out.println("main2 " + threadLocal.get());

    }
}