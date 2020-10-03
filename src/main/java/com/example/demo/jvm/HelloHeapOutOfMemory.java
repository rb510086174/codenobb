package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By RenBin6 on 2020/9/4 .
 */
public class HelloHeapOutOfMemory {
    public static void main(String[] args) {
        System.out.println("HelloHeapOutOfMemory");
        List<Person> list = new ArrayList<Person>();
        int counter = 0;
        while (true){
            list.add(new Person());
            System.out.println("Instance: " + (++counter));
        }
    }

}
class Person{}