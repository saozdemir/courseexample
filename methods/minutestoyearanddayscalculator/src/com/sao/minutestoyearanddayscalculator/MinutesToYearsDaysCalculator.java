package com.sao.minutestoyearanddayscalculator;

public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(minutes + " min = " + (minutes / (60 * 24)) / 365 + " y and " + (minutes / (60 * 24)) % 365 + " d");
        }
    }
}
