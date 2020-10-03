package com.example.demo.test;

/**
 * Created By RenBin6 on 2020/7/22 .
 */
public abstract class DogAbstract {
    private String animal = "dog";
    private String type;
    void shout(){};
    void eat(String meat){
        System.out.println(meat);
    };

    public DogAbstract(String animal, String type) {
        this.animal = animal;
        this.type = type;
        System.out.println( animal + type);
    }
}
