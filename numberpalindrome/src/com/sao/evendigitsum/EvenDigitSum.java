package com.sao.evendigitsum;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number) {
        int sum = 0;
        int digit = 0;
        if (number < 0) {
            return -1;
        } else {
            while (number > 0) {
                digit = number % 10;
                if (digit % 2 == 0) {
                    sum += digit;
                }
                number /= 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }
}
