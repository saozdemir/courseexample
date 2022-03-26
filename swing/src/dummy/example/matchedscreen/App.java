package dummy.example.matchedscreen;

import dummy.example.matchedscreen.view.FrmMainScreen;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMainScreen();
            }
        });
    }
}
