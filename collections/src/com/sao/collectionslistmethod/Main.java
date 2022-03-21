package com.sao.collectionslistmethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Ahmet", 8, 12);
        //theatre.getSeats();
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); //listeyi kopyaladık. ArrayList constructorınıa değer gönderince kopyalar.
        printList(seatCopy);

        seatCopy.get(1).reserve(); //Kopyalanan listeden rezervasyon yapıldı
        if (theatre.reserveSeat("A02")) { //Normal listeden de aynı yere rezervasyon yapılmak istendiğinde yapmayacaktır (Reference Type)
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        //Collections.reverse(seatCopy); // elemanları karıştırma yaptı
        Collections.reverse(seatCopy); // kopyalanan liste terslendi
        System.out.println("Printing Seat Copy List:  ");
        printList(seatCopy);
        System.out.println("Printing Normal List:  ");
        printList(theatre.seats); //public access modifiers yapıldığı için doğrudan erişim var.
        /**
         * Yazdırma işlemi sonunda kopya liste terslenir ancak normal liste olduğu gibi kalır.
         * Kopyalama işlemi sırasında iki farklı liste oluşturulur ancak her elemanın nesnesi iki liste için de ortak.
         * Yani listeler farklı olsa bile listelerin içindeki koltuklar aynı referans tipe sahip
         */

        Collections.shuffle(seatCopy);
        printList(seatCopy);
        sortList(seatCopy);
        printList(seatCopy);

        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList,theatre.seats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println("\n=========================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

}
