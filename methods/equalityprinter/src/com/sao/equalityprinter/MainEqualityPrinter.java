package com.sao.equalityprinter;

import static com.sao.equalityprinter.IntEqualityPrinter.printEqual;

public class MainEqualityPrinter {
    public static void main(String[] args) {
        printEqual(1, 1, 1);
        printEqual(1, 1, 2);
        printEqual(-1, -1, -1);
        printEqual(1, 2, 3);
    }
}
