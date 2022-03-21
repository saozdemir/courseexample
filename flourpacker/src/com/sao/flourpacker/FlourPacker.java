package com.sao.flourpacker;

public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        if (goal > ((bigCount * 5) + smallCount)) {
            return false;
        }

        if ((goal % 5) > smallCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        //System.out.println(canPack(1, 0, 5));
        //System.out.println(canPack(0, 5, 4));
        //System.out.println(canPack(2, 2, 11));
        //System.out.println(canPack(-3, 2, 12));
        //System.out.println(canPack(5, 3, 24));
        System.out.println(canPack(1, 0, 5));
    }
}
