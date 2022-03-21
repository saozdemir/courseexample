package com.sao.sets;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) { //Alt sınıflarda override a kapadık.
        if (this == obj) { //Hafızada aynı yerde mi?
            return true;
        }
        if (obj instanceof Dog) { // İlgili sınıfın nesnesi mi?
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName); //İsmi aynı mı?
        }
        return false;
    }
}
