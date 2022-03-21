package com.sao.setchallange;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody { //Bu sınıfın doğrudan nesnesi oluşturularak BodyType girilebiliyordu. Abstract yaparak bu girişi önledik
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites); // kod güvenliği için doğrudan set collectionumuza erişim vermiyor yeni bir nesne ile referasn gönderiyoruz.
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);

    }

    /**
     * Alt sınıfların düzenlemesini kapatmak için equals ve hashCode metotlarını final yaptık
     * Böylece alt sınıflar override etmeden gelip burada çalışacaklar
     */

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) { //Aynı nesne olup olmadığını kontrol ettik.
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;//casting
            return this.key.equals(theObject.getKey());
        }
        return false;
    }


    /**
     * Yukarıda iki adet pluto instance'ı oluşturuldu. Nesneler yani instance oluşturulurken new ile oluşturulduğu için hashcodeları farklı oldu.
     * Aynı isme sahip gök cisimleri için aynı hashcode u üreten bir yapı oluşturmak için hashcode metodunu override ettik
     */
    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + "\t : " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return this.name + "\t : " + this.bodyType;
        }
    }
}
