package com.sao.finalstatement;

public class StaticInitializationBlockTest {
    public static final String owner;

    static {
        owner = "tim";
        System.out.println("StaticInitializationBlockTest static initialization block called");
    }

    public StaticInitializationBlockTest() {
        System.out.println(this.getClass().getName().toString() + " constructor called");
    }

    static {
        System.out.println("Second static initialization block called");
    }

    public void someMethod(){
        System.out.println("SomeMethod called");
    }
}
