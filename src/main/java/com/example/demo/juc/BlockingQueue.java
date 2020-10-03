package com.example.demo.juc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueue<T> {
    private Queue<T> mQueue = new LinkedList<>();
    private int mCapacity;

    public BlockingQueue(int capacity) {
        this.mCapacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException{
        while (mQueue.size() == mCapacity){
            wait();
        }
        mQueue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException{
        while (mQueue.isEmpty()){
            wait();
        }
        T item = mQueue.remove();
        notify();
        return item;
    }

    public static void main(String[] args) throws Exception {
        BlockingQueue blockingQueue = new BlockingQueue(5);


        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    try {
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("put: " + i);
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    Object take = null;
                    try {
                        take = blockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("take: " + take);
                }
            }
        });





    }

}