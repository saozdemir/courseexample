package com.sao.finalstatement;

public class MainStaticInit {
    public static void main(String[] args) {
        System.out.println("Main method called");
        StaticInitializationBlockTest test = new StaticInitializationBlockTest();
        test.someMethod();
        System.out.println("Owner is " + StaticInitializationBlockTest.owner);
    }
}
