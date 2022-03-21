package com.sao.polimorphizm;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.acclerate());
        System.out.println(car.breake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.acclerate());
        System.out.println(mitsubishi.breake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.acclerate());
        System.out.println(ford.breake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.acclerate());
        System.out.println(holden.breake());

        Car carFord = new Ford(8, "Ford Escort");
        System.out.println(carFord.startEngine());
        System.out.println(carFord.acclerate());
        System.out.println(carFord.breake());
    }
}
