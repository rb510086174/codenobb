package com.example.demo.juc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBlockingQueue<T> {
    private Queue<T> mQueue = new LinkedList<>();
    private int mCapacity;
    private Lock mLock = new ReentrantLock();
    private Condition mNotFull = mLock.newCondition();
    private Condition mNotEmpty = mLock.newCondition();

    public ConditionBlockingQueue(int capacity) {
        this.mCapacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException{
        mLock.lockInterruptibly();
        try {
            while (mQueue.size() == mCapacity){
                mNotFull.await();
            }
            mQueue.add(element);
            mNotFull.signal();
        }finally {
            mLock.unlock();
        }
    }

    public synchronized T take() throws InterruptedException{
        mLock.lockInterruptibly();
        try {
            while (mQueue.size() == 0){
                mNotEmpty.await();
            }
            T item = mQueue.remove();
            mNotEmpty.signal();
            return item;
        }finally {
            mLock.unlock();
        }
    }

}