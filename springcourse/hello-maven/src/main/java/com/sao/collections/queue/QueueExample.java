package com.sao.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        System.out.println("Java Queue Example");

        Queue<String> myQueue = new LinkedList<>();

        // Eleman ekleme
        myQueue.add("Ahmet");
        myQueue.add("Esra");
        myQueue.add("Emir");
        myQueue.add("Badem");
        myQueue.add("Tarçın");

        // Elemanları yazdırma
        System.out.println("Queue elements: " + myQueue);

        // Eleman çıkarılması
        String firstElement = myQueue.poll();
        System.out.println("Removed element: " + firstElement);

        // Kuyruktaki ilk elemanı almadan kaldırma
        String secondElement = myQueue.remove();
        System.out.println("Removed element: " + secondElement);

        // Kuyruğun ilk elemanını alma
        String peekedElement = myQueue.peek();
        System.out.println("Peeked element: " + peekedElement);

        // Kuyruktaki eleman sayısı
        int size = myQueue.size();
        System.out.println("Queue size: " + size);

        // Elemanları yazdırma (tekrar)
        System.out.println("Queue elements: " + myQueue);
    }
}


