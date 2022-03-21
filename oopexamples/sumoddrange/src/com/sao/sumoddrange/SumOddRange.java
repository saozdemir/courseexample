package com.sao.sumoddrange;

public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number > 0) {
            if (number % 2 != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start < 0 || end < 0) {
            return -1;
        } else {
            if (end >= start) {
                for (int i = start; i <= end; i++) {
                    if (isOdd(i)) {
                        sum += i;
                    }
                }
                return sum;
            } else {
                return -1;
            }
        }

    }
}
