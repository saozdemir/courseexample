package com.sao.polimorphizm;

public class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford -> startEngine()";
    }

    @Override
    public String acclerate() {
        return "Ford -> acclerate()";
    }

    @Override
    public String breake() {
        return "Ford -> breake() ";
    }
}
