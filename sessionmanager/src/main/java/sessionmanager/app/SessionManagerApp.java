package sessionmanager.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author saozd
 * @project sessionmanager.app courseexample
 * 13.07.2023 Tem 2023
 */
public class SessionManagerApp {
    public static void main(String[] args) {
        System.out.println("Session Manager");
        long lockTime = getSessionLockTime();
        System.out.println("Session lock time: " + lockTime + " milliseconds");
    }

    public static long getSessionLockTime() {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c quser");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            long idleTime = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains("console")) {
                    String[] parts = line.trim().split("\\s+");
                    String idleTimeString = parts[parts.length - 2];
                    idleTime = parseIdleTime(idleTimeString);
                    break;
                }
            }

            reader.close();
            process.destroy();

            return idleTime;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    private static long parseIdleTime(String idleTimeString) {
        String[] parts = idleTimeString.split(":");

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        long idleTime = (hours * 3600 + minutes * 60 + seconds) * 1000;

        return idleTime;
    }
}
