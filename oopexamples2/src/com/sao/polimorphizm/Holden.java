package com.sao.polimorphizm;

public class Holden extends Car{
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Holden -> startEngine()";
    }

    @Override
    public String acclerate() {
        return "Holden -> acclerate()";
    }

    @Override
    public String breake() {
        return "Holden -> breake() ";
    }
}
