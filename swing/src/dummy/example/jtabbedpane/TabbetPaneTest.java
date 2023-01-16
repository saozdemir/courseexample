package dummy.example.jtabbedpane;

import javax.swing.*;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class TabbetPaneTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TabbetPane();
            }
        });
    }
}
