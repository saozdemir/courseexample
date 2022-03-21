package com.sao.finalstatement;

public class Main {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");
        //int pass = 6;
        //int cry = 13;

        int pw = 6;

        //Password password = new Password(pw);
        Password password = new ExtendedPassword(pw);
        password.storePassword();

        password.letMeIn(123);
        password.letMeIn(6);
        System.out.println("******************************************************\n");


    }

}
