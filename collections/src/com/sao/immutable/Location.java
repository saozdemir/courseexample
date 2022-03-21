package com.sao.immutable;

import java.util.HashMap;
import java.util.Map;

final public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits; //

    public Location(int locationID, String description, Map<String, Integer> exits) { //Sınıfın içinden ekleme yaptırmak yerine referasn alıyoruz.
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new HashMap<String,Integer>(exits);// yeni bir map oluşturup referansımızı cosntructor a gönderiyorız!!!!
        } else {
            this.exits = new HashMap<String, Integer>(); // String pusula yönü("W" gibi), Integer o yöndeki location numarası
        }
        this.exits.put("Q", 0);// çıkış constructor altında tanımlandı. (this.exits olmaı)
    }

    //Dışarından sınfı içindeki map referansının değişimini engeledik. Artık constructor içindeki referans ile işlem yapacağız.

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
