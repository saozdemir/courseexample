package com.sao.sets;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites); // kod güvenliği için doğrudan set collectionumuza erişim vermiyor yeni bir nesne ile referasn gönderiyoruz.
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }


    @Override
    //Bu annotationu kapattık bu durumda method overloading yapılmış oldu. Ama bu durumda Collectionsta kullanılmaz. Aşağıdaki işlemi yaptık.
    public boolean equals(Object obj) { // HeavenlyBody obj herine bunu yazdık override edildi. Yukarıdaki gibi overlodaing işimize yaramıyordu.
        // amacımız bu metodu collections için kullanılır yapmak ve asıl metodu geçersiz kılarak polimorfizm yapmak
        if (this == obj) { //Aynı nesne olup olmadığını kontrol ettik.
            return true;
        }

        System.out.println("obj.getClass() " + obj.getClass());
        System.out.println("this.getClass() " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName(); //Override Object sınınıfını parametre olarak istediği için casting yapıldı
        return this.name.equals(objName);
    }


    /**
     * Yukarıda iki adet pluto instance'ı oluşturuldu. Nesneler yani instance oluşturulurken new ile oluşturulduğu için hashcodeları farklı oldu.
     * Aynı isme sahip gök cisimleri için aynı hashcode u üreten bir yapı oluşturmak için hashcode metodunu override ettik
     */
    @Override
    public int hashCode() {
        System.out.println("hascode called");
        return this.name.hashCode() + 57; //Her isntance'ın ismine göre hashcode üretilip döndürüldü.
    }
}
