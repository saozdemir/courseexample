package _sw12events.example2;

import javax.swing.*;

public class AppListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMain();
            }
        });
    }
}
