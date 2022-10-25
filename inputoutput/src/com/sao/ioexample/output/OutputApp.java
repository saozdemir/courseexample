package com.sao.ioexample.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OutputApp {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("E:\\IdeaProjects\\courseexample\\inputoutput\\src\\com\\sao\\ioexample\\log\\log.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String log;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");


            for (int i = 0; i < 5; i++) {
                Date date = (Date) Calendar.getInstance().getTime();
                String dateStr = dateFormat.format(date);
                log = "[LOG] " + dateStr + " Log Kaydı - (" + i + ") [END]" + "\n";
                bufferedWriter.write(log);
                Thread.sleep(500 + i);
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Dosya Oluşturma Hatası");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
