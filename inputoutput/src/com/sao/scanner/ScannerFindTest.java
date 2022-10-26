package com.sao.scanner;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerFindTest {
    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fishx[]";
        Scanner s = new Scanner(input);
        //s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
//        s.findInLine("(.*) blue (.*)");
        s.findInLine("(.*) fishx\\[\\]");
        MatchResult result = s.match();
        for (int i = 1; i <= result.groupCount(); i++)
            System.out.println(result.group(i));
        s.close();
    }
}
