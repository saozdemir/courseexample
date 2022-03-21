package com.sao.firstandlastdigitsum;

public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number) {
        int firstDigit = number % 10;
        int lastDigit = 0;

        if (number < 0) {
            return -1;
        } else {
            while (number > 0) {
                lastDigit = number  % 10;
                number  /= 10;
            }
            return firstDigit + lastDigit;
        }
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
    }
}
