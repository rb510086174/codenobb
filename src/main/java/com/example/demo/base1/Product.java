package com.example.demo.base1;

public class Product implements Cloneable {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        try {   
            return super.clone();   
        } catch (CloneNotSupportedException e) {   
            return null;   
        }   
    }

    public static void main(String[] args) {
        Product product_a = new Product("测试");
        Product clone_b = (Product) product_a.clone();
        if (clone_b.getName() == product_a.getName()){
            System.out.println("==");
        }
        if (clone_b.getName().equals(product_a.getName()) ){
            System.out.println("equals");
        }
        System.out.println("不等哦");
    }
}  