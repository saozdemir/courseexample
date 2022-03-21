package com.sao.areacalculator;

public class MainArea {
    public static void main(String[] args) {
        System.out.println(AreaCalculator.area(5.0));
        System.out.println(AreaCalculator.area(-1.0));
        System.out.println(AreaCalculator.area(5.0, 4.0));
        System.out.println(AreaCalculator.area(-1.0, 4.0));
    }
}
