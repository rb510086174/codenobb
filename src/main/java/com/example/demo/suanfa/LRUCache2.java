package com.example.demo.suanfa;

import java.util.*;

public class LRUCache2 {
    private LinkedHashMap<Integer, Integer> cache;
    private Integer capacity;

    public LRUCache2(LinkedHashMap<Integer, Integer> cache, Integer capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public  int get(int key){
        if (!cache.containsValue(key)) return -1;
        int val = cache.get(key);
        cache.remove(key);// 从链表中删除
        cache.put(key,val); // 添加到链尾
        return val;
    }

    public void put (int key, int value){
        if (cache.containsValue(key)){
            cache.remove(key); // 已经存在，链表中删除
        }

        if (capacity.equals(cache.size()) ){
            // cache 已满,删除链表头
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }

        cache.put(key, value);// 添加到链尾
    }

    public static void main(String[] args) {

        Integer  a = 2031234001;
        System.out.println("a%1000 : " + a%1000);
        List list = new ArrayList(20000);
        System.out.println(a == list.size());
    }
}