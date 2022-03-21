package com.sao.mapsadventure;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>(); // String pusula yönü("W" gibi), Integer o yöndeki location numarası
        exits.put("Q",0);// çıkış constructor altında tanımlandı.
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
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

//    public Map<Integer, String> getExits() {
//        //return exits;
//        return new HashMap<Integer, String>(exits); //final olarak tanımlandığı için yeni bir map oluşturup exits collectionumuzu constructor ile
//        // içine gönderdiyoruz. Böylece kullanıma açık ve map içindeki nesnelerin tüm eşleşmelerine sahip oluyor.
//    }