package com.sao.binarysearch;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Ahmet", 6, 12);
        //theatre.getSeats();

        if(theatre.reserveSeat("A10")){
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is taken");
        }

        if(theatre.reserveSeat("A10")){
            System.out.println("Please pay");
        } else {
            System.out.println("Seat is taken");
        }

    }
}
