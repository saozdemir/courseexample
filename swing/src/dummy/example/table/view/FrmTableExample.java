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

        pnlTableExample = new PnlTableExample();
        this.add(pnlTableExample, BorderLayout.CENTER);

        controller = new CtrTableExample(this);// Controlleri tanımlarken en sonda tanımla yoksa nullpointer alırsın
    }

    public PnlTableExample getPnlTableExample() {
        return pnlTableExample;
    }
}
