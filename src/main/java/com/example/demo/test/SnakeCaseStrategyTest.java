package com.example.demo.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Created By RenBin6 on 2020/9/4 .
 */
public class SnakeCaseStrategyTest {
    public static void main(String[] args) {
        PropertyNamingStrategy.SnakeCaseStrategy snakeCaseStrategy = new PropertyNamingStrategy.SnakeCaseStrategy();
        String iputStreamBuilder = snakeCaseStrategy.translate("iputStreamBuilder");
        System.out.println(iputStreamBuilder);
    }
}
