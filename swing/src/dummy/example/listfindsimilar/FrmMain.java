package dummy.example.listfindsimilar;

import javax.swing.*;
import java.awt.*;

public class FrmMain extends JFrame {
    PnlMain pnlMain = new PnlMain();

    public FrmMain() throws HeadlessException {
        this.setTitle("Dynamic Text Field");
        this.setSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(pnlMain, BorderLayout.CENTER);
    }
}
