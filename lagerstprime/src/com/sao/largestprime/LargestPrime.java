package com.sao.largestprime;

public class LargestPrime {
    public static int getLargestPrime(int number) {
        if (number >= 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    number /= i;
                    i--;
                }
            }
            return number;
        }
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println(getLargestPrime(21));
        //System.out.println(getLargestPrime(217));
        //System.out.println(getLargestPrime(-1));
        System.out.println(getLargestPrime(7));
    }
}
