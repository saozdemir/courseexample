package com.sao.decimalcomparator;

public class MainComparator {
    public static void main(String[] args) {
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }
}
