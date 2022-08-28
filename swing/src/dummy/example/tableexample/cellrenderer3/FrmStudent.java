package dummy.example.tableexample.cellrenderer3;

import javax.swing.*;
import java.awt.*;

public class FrmStudent extends JFrame {
    private PnlStudent pnlCommon = new PnlStudent();
    public FrmStudent() {
        init();
    }

    private void init() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(pnlCommon, BorderLayout.CENTER);
    }
}
