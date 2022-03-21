package com.sao.polimorphizm;

public class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String acclerate() {
        return "Mitsubishi -> acclerate()";
    }

    @Override
    public String breake() {
        return "Mitsubishi -> breake() ";
    }
}
