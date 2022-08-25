package dummy.example.tableexample.cellrenderer2;

import javax.swing.*;

public class AppTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmCellRenderer();
            }
        });
    }
}
