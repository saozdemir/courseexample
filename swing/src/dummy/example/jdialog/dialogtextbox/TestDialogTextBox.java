package dummy.example.jdialog.dialogtextbox;

import javax.swing.*;

public class TestDialogTextBox {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMain();
            }
        });
    }
}
