//package com.example.demo.jvm;
//
//import org.openjdk.jol.info.ClassLayout;
//import org.openjdk.jol.vm.VM;
//
//public class JOLSample_01_Basic {
//
//    public static void main(String[] args) throws Exception {
//        System.out.println(VM.current().details());
//        ClassLayout layout = ClassLayout.parseInstance(new A());
//
//        System.out.println(layout.toPrintable());
//    }
//
//    public static class A {
//        boolean f;
//    }
//}