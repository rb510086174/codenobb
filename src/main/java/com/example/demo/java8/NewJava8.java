package com.example.demo.java8;

import com.example.demo.base1.User;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By RenBin6 on 2020/8/25 .
 */
public class NewJava8 {
    {

    }


    public static void fenzu(List<Apple> appleList){
        //List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:"+groupBy);
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合
        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);
        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        fenzu(appleList);
    }
    public static void toMap(List<Apple> appleList){
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));

    }

    public static void filter(List<Apple> appleList){
        //过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());

        System.err.println("filterList:"+filterList);
    }

    public static void count(List<Apple> appleList){
    //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48
    }

}
