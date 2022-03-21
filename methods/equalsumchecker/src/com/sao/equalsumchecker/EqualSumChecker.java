package com.sao.equalsumchecker;

public class EqualSumChecker {
    public static boolean hasEqualSum(int firstNumber, int secondNumber, int result) {
        if ((firstNumber + secondNumber) == result) {
            return true;
        } else {
            return false;
        }
    }
}
