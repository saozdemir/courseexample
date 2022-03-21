package com.sao.linkedlist.demo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ahmet", 50.24);


        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(3);
        integers.add(4);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("[" + i + "]" + integers.get(i));
        }
        System.out.println("***");

        integers.add(1, 2);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("[" + i + "]" + integers.get(i));
        }

    }
}
