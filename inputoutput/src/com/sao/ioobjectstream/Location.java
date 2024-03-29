package com.sao.ioobjectstream;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ObjectInputStream ve ObjectOutputStrem ile bu sınıfı kullanabilmek için serileştirme yapmamız gerekmektedir.
 */
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    //Yukarııda id description primitive typetır. Ancak exits Map nesnesidir. Bu nedenle dosyaya yazarken seri hale getirilecek!!!
    private long serialVersionUID = 1L; //Serileştirme için UID tanımladık.

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q", 0);
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }
}
