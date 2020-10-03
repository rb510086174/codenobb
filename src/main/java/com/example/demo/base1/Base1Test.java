package com.example.demo.base1;

import com.example.demo.test.KejiDog;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created By RenBin6 on 2020/8/24 .
 */
public class Base1Test {

    public static void test1() {
        Integer a = 20;
        Integer b = 20;
        if (a == b) {
            System.out.println("20 ==");

        }
    }

    public static void test2() {
        Integer a = 220;
        Integer b = 220;
        if (a.equals(b)) {
            System.out.println("220 equals 登");
        } else {
            System.out.println("220 equals 不等 ");
        }

    }

    //值传递 引用传递
    public static void test3() {
        String a = "dasdasdasdasdasdasas";
        test4(a);
        System.out.println(a);
    }

    //值传递 引用传递
    public static void test4(String test) {
        String a = "dasdasdasdasdasdasas";
        test = test + a;

    }

    //值传递 引用传递
    public static void test5() {
        String[] a = new String[]{"dasdasdasdasdasdasas", "hehhe"};
        test6(a);
        System.out.println(Arrays.toString(a));
    }

    //值传递 引用传递
    public static void test6(String[] test) {
        String a = "xxx";
        test[0] = a;

    }

    public static void testString() {
        StringBuilder sb = new StringBuilder("dasdasdas");
        char c = sb.charAt(1);
        System.out.println(c);
        sb.setLength(0);
        sb.append(" test");
        char cc = sb.charAt(1);
        System.out.println(cc);
        System.out.println("sb: " + sb.toString());
    }

    public static void testStringTokenizer() {
        StringTokenizer st = new StringTokenizer("hello world,sex lady");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }


    }

    public static void test() {
        List<String>  gg = new ArrayList<>();
        gg.add("baa");
        gg.add("a11");
        gg.add("11");
        gg.add("cc");
        System.out.println(Arrays.toString(gg.toArray()));
        Collections.sort(gg,(a,b) -> a.compareTo(b));
        System.out.println(Arrays.toString(gg.toArray()));
    }
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test();
//      User user1 = new User();
//      user1.setPassword("12345");
//      user1.setUserName("admin");
//        KejiDog kejiDog = new KejiDog("小型犬");
//        user1.setPet(kejiDog);
//        User copy = copy(user1);
//        System.out.println(copy.getUserName() + ":" + copy.getPassword());
//        System.out.println(copy.getPet());
        constructor();
    }

    public static <T extends Serializable> T copy(T input) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(input);
            oos.flush();

            byte[] bytes = baos.toByteArray();
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            Object result = ois.readObject();
            return (T) result;
        } catch (IOException e) {
            throw new IllegalArgumentException("Object can't be copied", e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to reconstruct serialized object due to invalid class definition", e);
        } finally {
            closeQuietly(oos);
            closeQuietly(baos);
            closeQuietly(bis);
            closeQuietly(ois);
        }
    }
    public static void closeQuietly(Closeable object){
        if(null != object){
            try {
                object.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void constructor(){
        List<String> list = new ArrayList();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();

        }

        List<String> list2 = new ArrayList();
        list2.add("test1");
        list2.add("test2");
        list2.add("test3");
        for (int i = 0; i < list2.size(); i++) {
            list2.remove(2);
            System.out.println(list2.get(i));
        }
    }

}
