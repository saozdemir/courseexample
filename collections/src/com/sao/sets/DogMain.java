package com.sao.sets;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");


        /**
         * Eğer Labrador alt sınıfı için de equals metodu override edilseydi 2. ifade false olacaktı.
         * Çünkü Labrador bir Dog instance ıdır
         * Ancak Dog bir labrador instance ı değildir. labrador içinde equals override edilirse
         * sadece labrador için geçerli olacaktır. O nedenle override etmeden üst sınıf olan Dog'a
         * gidip kullanmalıdır.
         */
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));

    }
}
