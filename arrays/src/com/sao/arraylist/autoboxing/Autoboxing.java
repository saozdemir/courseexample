package com.sao.arraylist.autoboxing;

import java.util.ArrayList;

public class Autoboxing {
    static ArrayList<Integer> integer = new ArrayList<Integer>();// Wrapper Class for int primitive type definition to ArrayList

    public static void main(String[] args) {
        integer.add(Integer.valueOf(65)); //Autoboxing
        System.out.println(integer.get(0).intValue()); //Unboxing

        integer.add(70); //Background code is woking Integer.valueOf(70) (Compile time)
        System.out.println(integer.get(1)); //Background code is working integer.get(1).intValue(); (Compile time)
    }

}
