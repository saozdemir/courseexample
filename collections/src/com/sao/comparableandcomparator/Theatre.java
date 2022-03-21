package com.sao.comparableandcomparator;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null); //Binary Search yaptık
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve(); // bulunan indexe sahip koltuk için reserve metodunu çağır.
        } else {
            System.out.println("No found seat  " + seatNumber);
            return false;
        }
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
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
