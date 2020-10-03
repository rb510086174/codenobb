package com.example.demo.juc;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created By RenBin6 on 2020/9/17 .
 */
public class CyclicBarrierService implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4,this);
    private Executor executor = Executors.newFixedThreadPool(4);
    ConcurrentMap<String,Integer> count = new ConcurrentHashMap();
    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String,Integer> entry: count.entrySet()) {
            result += entry.getValue();
        }
        count.put(Thread.currentThread().getName()+"_result", result);
        System.out.println("指定大哥先走，size: " + count.size() + "  result:"+ result );
    }

    public void cal(){
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                count.put(Thread.currentThread().getName(),10);
                try {
                    System.out.println("waiting...");
                    cyclicBarrier.await();
                    System.out.println("working...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
//        cyclicBarrier.reset();
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                count.put(Thread.currentThread().getName(),10);
                try {
                    System.out.println("waiting  第二发...");
                    cyclicBarrier.await();
                    System.out.println("working     第二发...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierService().cal();
    }
}
