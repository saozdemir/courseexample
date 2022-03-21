package com.sao.greatestcommondivisor;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        } else {
            int counter = first;
            int greaterCommonDivisor = 1;
            if (first >= second) {
                counter = second;
            }
            for (int i = 1; i <= counter; i++) {
                if (first % i == 0 && second % i == 0) {
                    greaterCommonDivisor = i;
                }
            }
            return greaterCommonDivisor;
        }
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
}
