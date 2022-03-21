package com.sao.lastdigitchecker;

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        if (isValid(number1) && isValid(number2) && isValid(number3)) {
            if ((number1 % 10 == number2 % 10)
                    || (number1 % 10 == number3 % 10)
                    || (number2 % 10 == number3 % 10)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isValid(int number) {
        if (number >= 10 && number <= 1000) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
    }
}
