package com.sao.scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerSplitTest {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("E:\\IdeaProjects\\courseexample\\inputoutput\\src\\com\\sao\\scanner\\log\\logC.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(reader);

            List<String> logs = new ArrayList<>();
            String log = "";
            while (scanner.hasNextLine()) {
                //String patternStr = "(.*) transaction error";
                String patternStr = ", transaction error";
                scanner.useDelimiter(patternStr);

                String logLine = scanner.nextLine();

                if (logLine.contains(patternStr)) {
                    log += logLine;
                    //System.out.println(log);
                    logs.add(log);
                    log = "";
                } else {
                    log += logLine;

                }

//                Pattern pattern = Pattern.compile(patternStr);
//
//                Matcher matcher = pattern.matcher(logLine);
//                if (matcher.find()) {
//                    log = "";
//                    System.out.println("Found value: " + matcher.group(0));
//                } else {
//                    System.out.println("-----");
//                    log += logLine;
//                }

//                scanner.findInLine("(.*) transaction error\\[\\]");
//                MatchResult result = scanner.match();
//                for (int i = 1; i <= result.groupCount(); i++)
//                    System.out.println(result.group(i));
//                Patt
            }
            System.out.println(logs.size());

            printLogs(logs);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printLogs(List<String> logs) {
        for (int i = 0; i < logs.size(); i++) {
            System.out.println("LOG: " + logs.get(i));
        }
    }
}
