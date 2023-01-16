package dummy.example.jtree;

import javax.swing.*;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class JTreeTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmJTree();
            }
        });
    }
}
