package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created By RenBin6 on 2020/9/12 .
 */
public class ProxyTester {

    private static Map<Integer,Integer> guolv = new HashMap<>();
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100 ; j++) {
                        if(null == ProxyTester.guolv.get(j) ){
                            guolv.put(j,j);
                            ProxyTester.save(j);
                        }
                    }
                }
            });
            thread.start();
        }



//    jdkProxt();
    }


    public static void test(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("stack peek: " + stack.peek());;
        System.out.println("stack pop: " + stack.pop());;
        System.out.println("stack peek after pop: " + stack.peek());;
    }
    public static void jdkProxt(){
        Singer singer = new Singer();
        ISinger s = (ISinger)Proxy.newProxyInstance(
                singer.getClass().getClassLoader(),
                singer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("hello , everyone");
                        Object invoke = method.invoke(singer, args);
                        System.out.println("thanks");
                        return invoke;
                    }
                }
        );

        s.sing();
    }
    public static void  save(int i){
        System.out.println("save : " + i);
    }
}
