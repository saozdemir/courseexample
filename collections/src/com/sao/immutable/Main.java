package com.sao.immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * Immutable class örneği için önceden mevcut olan addExits() metodu ile class içinde bulunan
         * exits mapine erişimi kapattık. Böylece dışarıdan bir map referansı alarak constructora
         * o referansı gönderiyoruz.
         */
        Map<String, Integer> tempExits = new HashMap<String, Integer>(); //Reference map objects

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));


        tempExits = new HashMap<String, Integer>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) { //Single character check
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) { // eğer anahtar kelime words dizisinde var ise
                        direction = vocabulary.get(word); //vocabulary mapında word keyine karşılık gelen sigle character i directiona ata
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction); //Integer ile tanımlanan direction numarasını loc'a ata.
            } else {
                System.out.println("You cannot go that direction");
            }
        }

    }
}
