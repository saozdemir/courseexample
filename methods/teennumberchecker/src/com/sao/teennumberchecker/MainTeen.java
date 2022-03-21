package com.sao.teennumberchecker;

import static com.sao.teennumberchecker.TeenNumberChecker.hasTeen;
import static com.sao.teennumberchecker.TeenNumberChecker.isTeen;

public class MainTeen {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(23, 15, 42));
        System.out.println(hasTeen(22, 23, 34));
        System.out.println("*-*-*-");
        System.out.println(isTeen(9));
        System.out.println(isTeen(13));
    }
}
