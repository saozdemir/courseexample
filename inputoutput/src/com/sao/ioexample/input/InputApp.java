package com.sao.ioexample.input;

import com.sao.ioexample.data.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputApp {
    public static void main(String[] args) {
        List<Log> logList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("E:\\IdeaProjects\\courseexample\\inputoutput\\src\\com\\sao\\ioexample\\log\\log.txt");
            Scanner scanner = new Scanner(new BufferedReader(fileReader));
            scanner.useDelimiter("[END]");

            while (scanner.hasNextLine()) {
                String log = scanner.next();
                if (log.contains("[LOG]")) {
                    Log dataLog = new Log();
                    dataLog.setLog(log);
                    logList.add(dataLog);
                }
            }
            scanner.close();
            System.out.println(logList.size());
        } catch (FileNotFoundException e) {
            System.err.println("Reader Error");
            throw new RuntimeException(e);
        }
    }
}
