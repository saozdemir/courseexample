package com.sao.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null); //Binary Search yaptık
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve(); // bulunan indexe sahip koltuk için reserve metodunu çağır.
        } else {
            System.out.println("No found seat  " + seatNumber);
            return false;
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) { //BinarySearch için başlangıç
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }
    }
}
