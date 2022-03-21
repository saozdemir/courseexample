package com.sao.linkedlist.demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<String>();

        addInOrder(placeToVisit, "İstanbul");
        addInOrder(placeToVisit, "Bursa");
        addInOrder(placeToVisit, "Eskişehir");
        addInOrder(placeToVisit, "Kütahya");
        addInOrder(placeToVisit, "Ankara");
        addInOrder(placeToVisit, "Konya");
        addInOrder(placeToVisit, "Niğde");
        printList(placeToVisit);

        addInOrder(placeToVisit, "Adana");
        printList(placeToVisit);

        addInOrder(placeToVisit, "Ankara");
        printList(placeToVisit);

        visit(placeToVisit);

//        placeToVisit.add("İstanbul");
//        placeToVisit.add("Bursa");
//        placeToVisit.add("Eskişehir");
//        placeToVisit.add("Kütahya");
//        placeToVisit.add("Ankara");
//        placeToVisit.add("Konya");
//        placeToVisit.add("Niğde");
//
//        printList(placeToVisit);
//
//        placeToVisit.add(1, "Çanakkale");
//        printList(placeToVisit);
    }

    private static void printList(LinkedList<String> placeToVisit) {
        Iterator<String> i = placeToVisit.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting: " + i.next());
        }
        System.out.println("===========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included as destination");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else {

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForvard = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting: " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForvard) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForvard = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("End of list");
                        goingForvard = false;
                    }
                    break;
                case 2:
                    if (goingForvard) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForvard = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("Beginning of list");
                        goingForvard = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Enter your choice: \n" +
                "[0] End Holiday\n" +
                "[1] Visit Next\n" +
                "[2] Visit Previous\n" +
                "[3] Print Menu\n");
    }


}
