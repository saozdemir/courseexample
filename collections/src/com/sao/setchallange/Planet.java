package com.sao.setchallange;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON) { // Her gök cismi için uyduların kontrolünü alt sınıflarda yapıp şartı geçerse eklemesi için üst sınıfa gönder
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
