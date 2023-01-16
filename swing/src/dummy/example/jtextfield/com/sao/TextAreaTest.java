package dummy.example.jtextfield.com.sao;

import javax.swing.*;

public class TextAreaTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmTextArea();
            }
        });

    }
}
