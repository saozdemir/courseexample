package com.sao.scanner;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerTest {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("E:\\IdeaProjects\\courseexample\\inputoutput\\src\\com\\sao\\scanner\\log\\log.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(reader);

            List<String> logs = new ArrayList<>();

            //scanner.useDelimiter("\\s*J3.2=\\s*");
            while (scanner.hasNextLine()) {
                //scanner.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
                scanner.findInLine("J3.2= (\\w+)");
                MatchResult result = scanner.match();
                for (int i=1; i<=result.groupCount(); i++)
                    System.out.println(result.group(i));


//                String str = scanner.next();
//                logs.add(str);
//                System.out.println(str);
            }
            System.out.println(logs.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
