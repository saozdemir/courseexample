package com.sao.perfectnumber;

public class PerfectNumber {
    public static boolean isPerfectNumber(int number) {
        int reminder = 0;
        if (number < 1) {
            return false;
        } else {
            for (int i = 1; i < number; i++) {
                if (number % i == 0)
                    reminder += i;
            }
            if (reminder == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }
}
