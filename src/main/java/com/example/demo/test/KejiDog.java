package com.example.demo.test;

/**
 * Created By RenBin6 on 2020/7/22 .
 */
public class KejiDog extends DogAbstract {
    public KejiDog(String type) {
        super(type,"hhe");
    }

    @Override
    void shout() {
        System.out.println("啊汪汪");
    }
}
