package com.sao.numberpalindrome;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        int copyNumber = number;
        int reverse = 0;
        int lastDigit = 0;
        while (copyNumber > 0) {
            lastDigit = copyNumber % 10;
            reverse = reverse * 10 + lastDigit;
            copyNumber = copyNumber / 10;
        }

        if (reverse == number) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }
}
