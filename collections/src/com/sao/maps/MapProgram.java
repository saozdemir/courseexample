package com.sao.maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, OOP platform independent language");
        languages.put("Pyton", "an independent OOP, high level programming language");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "beginners all purpose symbolic instruction code");
        languages.put("Lips", "madness");

        if (languages.containsKey("Java")) {
            System.out.println("Java already in the map");
        } else {
            languages.put("Java", "this course about java");
        }
        System.out.println("====================================================================================");
        for (String key : languages.keySet()) {
            System.out.println(key + "\t : " + languages.get(key));
        }

        for (String value : languages.values()) {
            System.out.println(value);
        }


//        System.out.println(languages.get("Java"));
//        languages.put("Java", "this course about java");
//        System.out.println(languages.get("Java"));
    }
}
