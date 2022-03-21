package com.sao.leapyear;

public class MainLeapYear {
    public static void main(String[] args) {
        System.out.println(LeapYear.isLeapYear(-1600));
        System.out.println(LeapYear.isLeapYear(1600));
        System.out.println(LeapYear.isLeapYear(2017));
        System.out.println(LeapYear.isLeapYear(2000));
    }
}
