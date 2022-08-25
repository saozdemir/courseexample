package dummy.example.tableexample.editabletable;

import javax.swing.*;
import java.awt.*;

public class FrmEditableTable extends JFrame {
    PnlEditableTable pnlEditableTable = new PnlEditableTable();

    public FrmEditableTable() {
        init();
    }

    private void init() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(pnlEditableTable, BorderLayout.CENTER);
    }
}
