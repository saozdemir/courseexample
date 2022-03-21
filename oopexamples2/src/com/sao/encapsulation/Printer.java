package com.sao.encapsulation;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount < 100) {
            if (tonerLevel + tonerAmount > 100) {
                return -1;
            } else {
                tonerLevel += tonerAmount;
                return tonerLevel;
            }
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {
        if (duplex) {
            System.out.println("Painting in duplex mode");
            pages = pages / 2 + pages % 2;
            this.pagesPrinted += pages;
            return pages;
        } else {
            this.pagesPrinted += pages;
            return pages;
        }

    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
