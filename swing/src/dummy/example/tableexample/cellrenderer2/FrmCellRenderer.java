package dummy.example.tableexample.cellrenderer2;

import javax.swing.*;
import java.awt.*;

public class FrmCellRenderer extends JFrame {
    private PnlCellRenderer pnlCommon = new PnlCellRenderer();

    public FrmCellRenderer() {
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
