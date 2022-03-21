package com.sao.sumoddrange;

import static com.sao.sumoddrange.SumOddRange.sumOdd;

public class MainRange {
    public static void main(String[] args) {
        System.out.println(sumOdd(1,100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
        System.out.println(sumOdd(100, -100));
        System.out.println(sumOdd(100, 1000));
        System.out.println(sumOdd(10, 5));
    }
}
