package com.sao.staticstatement;

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1. instance");
        System.out.println(firstInstance.getName() + "  " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2. instance");
        System.out.println(secondInstance.getName() + "  " + secondInstance.getNumInstances());


    }

}
