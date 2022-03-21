package com.sao.areacalculator;

public class AreaCalculator {
    public static double area(double x, double y) {
        if (x < 0 || y < 0) {
            System.out.println("Invalid value");
            return -1.0;
        } else {
            return x * y;
        }
    }

    public static double area(double radius) {
        if (radius < 0) {
            System.out.println("Invalid value");
            return -1.0;
        } else {
            return radius * radius * Math.PI;
        }
    }
}
