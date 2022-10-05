package com.sao.leapyear;

public class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println("Leap Year Calculator");

        calculateLeapYear(2000);
        calculateLeapYear(2001);
        calculateLeapYear(2002);
        calculateLeapYear(2003);
        calculateLeapYear(2004);
    }

    private static void calculateLeapYear(int year) {
        if ((year % 4) == 0 && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is Leap Year");
        } else {
            System.out.println(year + " is NOT Leap Year");
        }
    }
}
