package dummy.example.table.view;

import dummy.example.table.controller.CtrTableExample;

import javax.swing.*;
import java.awt.*;

public class FrmTableExample extends JFrame {
    private PnlTableExample pnlTableExample;
    private CtrTableExample controller;

    public FrmTableExample() {
        this.setVisible(true);
        this.setTitle("Table Example");
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        controller = new CtrTableExample(this);

        pnlTableExample = new PnlTableExample();
        this.add(pnlTableExample, BorderLayout.CENTER);
    }

    public PnlTableExample getPnlTableExample() {
        return pnlTableExample;
    }
}
